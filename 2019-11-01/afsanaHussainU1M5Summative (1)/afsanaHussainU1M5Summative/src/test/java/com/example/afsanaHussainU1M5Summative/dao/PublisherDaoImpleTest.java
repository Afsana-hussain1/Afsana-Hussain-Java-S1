package com.example.afsanaHussainU1M5Summative.dao;

import com.example.afsanaHussainU1M5Summative.models.Publisher;
import com.example.afsanaHussainU1M5Summative.models.Publisher;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class PublisherDaoImpleTest {


    //@Autowired:
    //connects the implementations of the AuthorDao class to the AuthorDaoImple class
    @Autowired
    private PublisherDao pDAO;

    @Before
    public void setUp() throws Exception {


            List<Publisher> publishers = pDAO.getAll();
            publishers.forEach(a -> pDAO.delete(a.getId()));
        }


        @Test
        public void addgetdelete(){
            Publisher publisher = new Publisher();
            publisher.setName("King");
            publisher.setState("NY");
            publisher.setStreet("666 evilplace");
            publisher.setCity("HalloweenTown");
            publisher.setPostalCode("123456");
            publisher.setEmail("ittheclown@gmail.com");
            publisher.setPhone("8867699");

            //Used to return an object with the same object with a new id value
            publisher = pDAO.add(publisher);

            assertEquals(publisher, pDAO.get(publisher.getId()));

            pDAO.delete(publisher.getId());

            assertNull(pDAO.get(publisher.getId()));

        }

        @Test
        public void getAllAuthors() {


            Publisher publisher = new Publisher();

            publisher.setName("King");
            publisher.setState("NY");
            publisher.setStreet("666 evilplace");
            publisher.setCity("HalloweenTown");
            publisher.setPostalCode("123456");
            publisher.setEmail("ittheclown@gmail.com");
            publisher.setPhone("8867699");

            pDAO.add(publisher);

            publisher = new Publisher();
            publisher.setName("King");
            publisher.setState("NY");
            publisher.setStreet("666 evilplace");
            publisher.setCity("Halloweentown");
            publisher.setPostalCode("123456");
            publisher.setEmail("ittheclown@gmail.com");
            publisher.setPhone("8867699");

            pDAO.add(publisher);
            //Redundant Step
            //List<Author> authors = aDAO.getAll();
            //assertEquals(2,authors.size());

            assertEquals(2, pDAO.getAll().size());
        }

        @Test
        public void updateAuthor(){

            Publisher publisher = new Publisher();
            publisher.setName("King");
            publisher.setState("NY");
            publisher.setStreet("666 evilplace");
            publisher.setCity("HalloweenTown");
            publisher.setPostalCode("123456");
            publisher.setEmail("ittheclown@gmail.com");
            publisher.setPhone("8867699");

            publisher = pDAO.add(publisher);

            publisher.setEmail("youwillfloattoo@gmail.com");
            publisher.setCity("Salem");

            pDAO.update(publisher);
            assertEquals(publisher,pDAO.get(publisher.getId()));

        }

    }
