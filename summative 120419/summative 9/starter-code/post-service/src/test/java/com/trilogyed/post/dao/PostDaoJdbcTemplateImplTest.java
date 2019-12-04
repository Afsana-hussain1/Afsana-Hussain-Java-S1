package com.trilogyed.post.dao;
import com.trilogyed.post.model.Post;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.time.LocalDate;
import java.util.List;
import static junit.framework.TestCase.assertNull;

import static org.junit.Assert.assertEquals;



@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class PostDaoJdbcTemplateImplTest {

    @Autowired

    PostDao postDao;

    @Before
    public void setUp() throws Exception {
        List<Post> postList = postDao.getAllPosts();

        postList.stream().forEach(post -> postDao.deletePost(post.getPostId()));

    }


    @Test
    public void addGetDeletePost() {
        Post post = new Post();
        post.setPostDate(LocalDate.of(2013, 12, 16));
        post.setPosterName("rin");
        post.setPost("pizza is good!");
        post = postDao.addPost(post);

        Post post1 = postDao.getPost(post.getPostId());



        assertEquals(post, post1);

        postDao.deletePost(post.getPostId());

        post1 = postDao.getPost(post.getPostId());

        assertNull(post1);



    }



    @Test
    public void getAllPosts() {
        Post post = new Post();
        post.setPostDate(LocalDate.of(2013, 12, 16));
        post.setPosterName("rin");
        post.setPost("pizza is good!");
        post = postDao.addPost(post);



        List<Post> postList = postDao.getAllPosts();

        assertEquals(1, postList.size());



    }

    @Test
    public void updatePost() {
        Post post = new Post();
        post.setPostDate(LocalDate.of(2013, 12, 16));
        post.setPosterName("rin");
        post.setPost("pizza is good!");
        post = postDao.addPost(post);

        post = postDao.addPost(post);

        post.setPostDate(LocalDate.of(2020, 4, 25));
        post.setPosterName("kim");
        post.setPost("naho likes her laces ");

        postDao.updatePost(post);
        Post post1 = postDao.getPost(post.getPostId());
        assertEquals(post, post1);

    }

    @Test
    public void getPostsByUser() {
        Post post = new Post();
        post.setPostDate(LocalDate.of(2013, 12, 16));
        post.setPosterName("rin");
        post.setPost("pizza is good!");
        post = postDao.addPost(post);


        List<Post> postList = postDao.getPostsByUser("rin");

        assertEquals(postList.size(),1);



    }

}