package com.trilogyed.stwitter.service;

import com.trilogyed.stwitter.feign.CommentServiceClient;
import com.trilogyed.stwitter.feign.PostServiceClient;
import com.trilogyed.stwitter.model.Comment;
import com.trilogyed.stwitter.model.Post;
import com.trilogyed.stwitter.viewModel.CommentViewModel;
import com.trilogyed.stwitter.viewModel.PostViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ServiceLayer {

    CommentServiceClient commentServiceClient;
     PostServiceClient postServiceClient;

    @Autowired
    public ServiceLayer(CommentServiceClient commentServiceClient, PostServiceClient postServiceClient) {
        this.commentServiceClient = commentServiceClient;
        this.postServiceClient = postServiceClient;
    }


    public PostViewModel addPost(PostViewModel postViewModel) {

        Post post = new Post();
        post.setPostDate(postViewModel.getPostDate());
        post.setPosterName(postViewModel.getPosterName());
        post.setPost(postViewModel.getPost());

        postServiceClient.addPost(post);
        postViewModel.setPostId(post.getPostID());
        return postViewModel;
    }


    public PostViewModel getPost(int id) {
        return buildViewModel(postServiceClient.getPost(id));

    }

    public List<PostViewModel> getPostbynameOfposter (String posterName){
        return postServiceClient.getPostsByPosterName(posterName).stream().map(this::buildViewModel).collect(Collectors.toList());
    }


    public PostViewModel buildViewModel (Post post) {
        List<String> comments = commentServiceClient.getCommentsByPostId(post.getPostID());
        PostViewModel postViewModel = new PostViewModel();
        postViewModel.setPostId(post.getPostID());
        postViewModel.setPostDate(post.getPostDate());
        postViewModel.setPosterName(post.getPosterName());
        postViewModel.setPost(post.getPost());
        postViewModel.setComments(comments);
        return postViewModel;
    }

}
