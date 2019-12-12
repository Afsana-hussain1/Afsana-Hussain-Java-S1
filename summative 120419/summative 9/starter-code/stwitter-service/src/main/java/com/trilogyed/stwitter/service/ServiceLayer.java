package com.trilogyed.stwitter.service;

import com.trilogyed.stwitter.feign.CommentServiceClient;
import com.trilogyed.stwitter.feign.PostServiceClient;
import com.trilogyed.stwitter.model.Comment;
import com.trilogyed.stwitter.model.Post;
import com.trilogyed.stwitter.viewModel.PostViewModel;
import com.sun.jersey.api.NotFoundException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ServiceLayer {

    public static final String EXCHANGE = "comment-exchange";
    public static final String ROUTING = "comment.create.servicetalker";

    CommentServiceClient commentServiceClient;
    PostServiceClient postServiceClient;
    RabbitTemplate template;

    @Autowired
    public ServiceLayer(CommentServiceClient commentServiceClient, PostServiceClient postServiceClient, RabbitTemplate template) {
        this.commentServiceClient = commentServiceClient;
        this.postServiceClient = postServiceClient;
        this.template = template;
    }


    public PostViewModel addPost(PostViewModel postViewModel) throws InterruptedException {
        Post post = new Post();
        post.setPostDate(postViewModel.getPostDate());
        post.setPosterName(postViewModel.getPosterName());
        post.setPost(postViewModel.getPost());

        post = postServiceClient.addPost(post);
        postViewModel.setPostId(post.getPostID());

        for (Comment comment : postViewModel.getComments()) {
            comment.setPostId(post.getPostID());
            template.convertAndSend(EXCHANGE, ROUTING, comment);
        }
        synchronized (postViewModel) {
            while (postViewModel.getComments().size() == 0) {
                wait(1000);
                postViewModel.setComments(commentServiceClient.getCommentsByPostId(postViewModel.getPostId()));
            }
        }


        return postViewModel;
    }


    @Transactional
    public Comment addComment(Comment comment, int postId) {
        Post post = postServiceClient.getPost(postId);
        if (post== null)
            throw new NotFoundException("No Post with that id is found");
         {

            comment.setPostId(postId);
            comment = commentServiceClient.addComment(comment);
            comment.setCommentId(comment.getCommentId());

        }

        return comment;
    }


    public PostViewModel getPost(int id) {
        return buildViewModel(postServiceClient.getPost(id));

    }

    public List<PostViewModel> getPostbynameOfposter (String posterName){
        return postServiceClient.getPostsByPosterName(posterName).stream().map(this::buildViewModel).collect(Collectors.toList());
    }




    public PostViewModel buildViewModel (Post post) {
        PostViewModel postViewModel = new PostViewModel();
        postViewModel.setPostId(post.getPostID());
        postViewModel.setPostDate(post.getPostDate());
        postViewModel.setPosterName(post.getPosterName());
        postViewModel.setPost(post.getPost());
        postViewModel.setComments(commentServiceClient.getCommentsByPostId(post.getPostID()));
        return postViewModel;
    }

}
