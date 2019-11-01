package com.example.afsanaHussainU1M5Summative.dao;

import com.example.afsanaHussainU1M5Summative.models.Author;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AuthorDAOImpleTest {
    //@Autowired:
    //connects the implementations of the AuthorDao class to the AuthorDaoImple class
    @Autowired
    private AuthorDao aDAO;

    @Before
    public void setUp(){
        List<Author> authors = aDAO.getAll();
        authors.forEach(a -> aDAO.delete(a.getId()));
    }


    @Test
    public void addgetdelete(){
        Author author = new Author();
        author.setFirstName("Stephen");
        author.setLastName("King");
        author.setState("MN");
        author.setStreet("666 evilplace");
        author.setCity("HalloweenTown");
        author.setPostalCode("123456");
        author.setEmail("ittheclown@gmail.com");
        author.setPhone("8867699");

        //Used to return an object with the same object with a new id value
        author = aDAO.add(author);

        assertEquals(author, aDAO.get(author.getId()));

        aDAO.delete(author.getId());

        assertNull(aDAO.get(author.getId()));

    }

    @Test
    public void getAllAuthors() {


        Author author = new Author();
        author.setFirstName("Stephen");
        author.setLastName("King");
        author.setState("MN");
        author.setStreet("666 evilplace");
        author.setCity("HalloweenTown");
        author.setPostalCode("123456");
        author.setEmail("ittheclown@gmail.com");
        author.setPhone("8867699");

        aDAO.add(author);

        author = new Author();
        author.setFirstName("Stephen");
        author.setLastName("King");
        author.setState("MN");
        author.setStreet("666 evilplace");
        author.setCity("Halloweentown");
        author.setPostalCode("123456");
        author.setEmail("ittheclown@gmail.com");
        author.setPhone("8867699");

        aDAO.add(author);
        //Redundant Step
        //List<Author> authors = aDAO.getAll();
        //assertEquals(2,authors.size());

        assertEquals(2, aDAO.getAll().size());
    }

    @Test
    public void updateAuthor(){

        Author author = new Author();
        author.setFirstName("Stephen");
        author.setLastName("King");
        author.setState("MN");
        author.setStreet("666 evilplace");
        author.setCity("HalloweenTown");
        author.setPostalCode("123456");
        author.setEmail("ittheclown@gmail.com");
        author.setPhone("8867699");

        author = aDAO.add(author);

        author.setEmail("youwillfloattoo@gmail.com");
        author.setCity("Salem");

        aDAO.update(author);
        assertEquals(author,aDAO.get(author.getId()));

    }

}