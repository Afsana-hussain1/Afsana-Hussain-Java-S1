package com.trilogyed.comment.dao;


import com.trilogyed.comment.model.Comment;
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
public class CommentDaoJdbcTemplateImplTest {
    @Autowired

     CommentDao commentDao;

    @Before
    public void setUp() throws Exception {
        List<Comment> commentList = commentDao.getAllComments();
        commentList.stream().forEach(comment -> commentDao.deleteComment(comment.getCommentId()));


    }

    @Test
    public void addGetDeleteComment() {

        Comment comment = new Comment();
        comment.setPostId(4);
        comment.setCreateDate(LocalDate.of(2012, 12, 26));
        comment.setCommenterName("bob");
        comment.setComment("I like pie");
        comment = commentDao.addComment(comment);

        Comment comment1 = commentDao.getComment(comment.getCommentId());

        assertEquals(comment, comment1);

        commentDao.deleteComment(comment.getCommentId());

        comment1 = commentDao.getComment(comment.getCommentId());

        assertNull(comment1);

    }



    @Test
    public void getAllComments() {

        Comment comment = new Comment();
        comment.setPostId(4);
        comment.setCreateDate(LocalDate.of(2012, 12, 26));
        comment.setCommenterName("bob");
        comment.setComment("I like pie");
        comment = commentDao.addComment(comment);


        Comment comment1 = new Comment();
        comment1.setPostId(2);
        comment1.setCreateDate(LocalDate.of(2003, 12, 26));
        comment1.setCommenterName("kim");
        comment1.setComment("im allergic to your cat");

        commentDao.addComment(comment1);
        List<Comment> commentList = commentDao.getAllComments();

        assertEquals(2, commentList.size());

    }



    @Test
    public void updateComment() {

        Comment comment = new Comment();
        comment.setPostId(4);
        comment.setCreateDate(LocalDate.of(2012, 12, 26));
        comment.setCommenterName("bob");
        comment.setComment("I like pie");
        comment = commentDao.addComment(comment);


        comment.setPostId(4);
        comment.setCreateDate(LocalDate.of(2012, 12, 26));
        comment.setCommenterName("kim");
        comment.setComment("I like pie");

        commentDao.updateComment(comment);

        Comment comment1 = commentDao.getComment(comment.getCommentId());

        assertEquals(comment, comment1);



    }



    @Test
    public void getCommentsByPostId() {

        Comment comment = new Comment();
        comment.setPostId(4);
        comment.setCreateDate(LocalDate.of(2012, 12, 26));
        comment.setCommenterName("bob");
        comment.setComment("I like pie");
        comment = commentDao.addComment(comment);



        List<Comment> commentList = commentDao.findCommentsByPostId(4);

        assertEquals(commentList.size(), 1);

        commentList = commentDao.findCommentsByPostId(9);

        assertEquals(commentList.size(), 0);

    }

}
