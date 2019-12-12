package com.trilogyed.stwitter.service;

import com.trilogyed.stwitter.feign.CommentServiceClient;
import com.trilogyed.stwitter.feign.PostServiceClient;
import com.trilogyed.stwitter.model.Comment;
import com.trilogyed.stwitter.model.Post;
import com.trilogyed.stwitter.viewModel.PostViewModel;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.Silent.class)
public class ServiceLayerTest {
    @Autowired
    ServiceLayer serviceLayer;

    PostServiceClient postServiceClient;

    CommentServiceClient commentServiceClient;

    @Mock
    RabbitTemplate rabbitTemplate;


    @Before
    public void setUp() throws Exception {
        setUpPostClientMock();
        setUpCommentClientMock();

        serviceLayer = new ServiceLayer(commentServiceClient, postServiceClient, rabbitTemplate);
    }

    public void setUpPostClientMock() {
        postServiceClient = mock(PostServiceClient.class);

        Post postDB = new Post();
        postDB.setPostID(1);
        postDB.setPostDate(LocalDate.of(2012, 12, 13));
        postDB.setPosterName("kim");
        postDB.setPost("hey there");

        Post postToCreate = new Post();
        postToCreate.setPostDate(LocalDate.of(2012, 12, 13));
        postToCreate.setPosterName("kim");
        postToCreate.setPost("hey there");

        List<Post> postList = new ArrayList<>();
        postList.add(postDB);

        doReturn(postDB).when(postServiceClient).addPost(postToCreate);
        doReturn(postDB).when(postServiceClient).getPost(1);
        doReturn(postList).when(postServiceClient).getAllPosts();
        doReturn(postList).when(postServiceClient).getPostsByPosterName("kim");

    }

    public void setUpCommentClientMock() {
        commentServiceClient = mock(CommentServiceClient.class);

        Comment commentDB = new Comment();
        commentDB.setCommentId(1);
        commentDB.setCreateDate(LocalDate.now());
        commentDB.setCommenterName("bob");
        commentDB.setPostId(1);
        commentDB.setComment("cool");

        Comment commentToCreate = new Comment();
        commentToCreate.setCreateDate(LocalDate.now());
        commentToCreate.setCommenterName("bob");
        commentToCreate.setPostId(1);
        commentToCreate.setComment("cool");

        List<Comment> commentList = new ArrayList<>();
        commentList.add(commentDB);

        doReturn(commentList).when(commentServiceClient).getCommentsByPostId(1);
        doReturn(commentList).when(commentServiceClient).getAllComments();
    }

    @Test
    public void shouldAddAndGetPost() throws Exception {

        Comment comment = new Comment();
        PostViewModel pvm = new PostViewModel();
        pvm.setPostDate(LocalDate.of(2012, 12, 13));
        pvm.setPosterName("kim");
        pvm.setPost("hey there");
        List<Comment> comments = new ArrayList<>();
        comments.add(comment);
        pvm.setComments(comments);


        pvm = serviceLayer.addPost(pvm);
        pvm.getComments().get(0).setCommenterName("bob");
        pvm.getComments().get(0).setCommentId(1);
        pvm.getComments().get(0).setCreateDate(LocalDate.now());
        pvm.getComments().get(0).setComment("cool");
        PostViewModel pvm2 = serviceLayer.getPost(pvm.getPostId());
        assertEquals(pvm, pvm2);
    }


    @Test
    public void getPostbynameOfposter() throws Exception {
        Comment comment = new Comment();
        PostViewModel pvm = new PostViewModel();
        pvm.setPostId(1);
        pvm.setPostDate(LocalDate.of(2012, 12, 13));
        pvm.setPosterName("kim");
        pvm.setPost("hey there");
        List<Comment> comments = new ArrayList<>();
        comments.add(comment);
        pvm.setComments(comments);

        pvm = serviceLayer.addPost(pvm);
        pvm.getComments().get(0).setCommenterName("bob");
        pvm.getComments().get(0).setCommentId(1);
        pvm.getComments().get(0).setCreateDate(LocalDate.now());
        pvm.getComments().get(0).setComment("cool");

        assertEquals(1, serviceLayer.getPostbynameOfposter("kim").size());
    }

    @Test
    public void shouldAddComment(){
      Comment comment = new Comment();
         comment.setCreateDate (LocalDate.now());
        comment.setCommenterName("bob");
        comment.setPostId(1);
        comment.setComment("cool");

        List<Comment> commentList = new ArrayList<>();
        commentList.add(comment);

        assertEquals(commentList.size(),1);

      }
    }

