package com.example.afsanaHussainU1M5Summative.dao;

import com.example.afsanaHussainU1M5Summative.models.Author;
import com.example.afsanaHussainU1M5Summative.models.Book;
import com.example.afsanaHussainU1M5Summative.models.Publisher;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class BookDaoImpleTest {

    @Autowired
    private AuthorDao authorDao;

    @Autowired
    private PublisherDao publisherDao;

    @Autowired

    private BookDao bookDao;

    private Author author;
    private Publisher publisher;

    @Before
    public void setUp() {
        bookDao.getAll().forEach(book -> bookDao.delete(book.getId()));

        author = new Author();
        author.setFirstName("Edward");
        author.setLastName("Scissorhands");
        author.setCity("Sleepy Hallow");
        author.setStreet("666");
        author.setState("NY");
        author.setPostalCode("55555");
        author.setEmail("1234@123.com");
        author.setPhone("1234567890");
        author = authorDao.add(author);

        publisher = new Publisher();
        publisher.setName("RL");
        publisher.setStreet("6666");
        publisher.setCity("city");
        publisher.setState("NY");
        publisher.setPostalCode("66666");
        publisher.setEmail("goosebumps@gmail.com");
        publisher.setPhone("6666666666");
        publisher = publisherDao.add(publisher);
    }

    @Test
    public void addGetDelete() {
        Book book = new Book();
        book.setAuthorId(author.getId());
        book.setIsbn("6666666XXX");
        book.setPublisherDate(LocalDate.of(1999, 10, 11));
        book.setPublisherId(publisher.getId());
        book.setPrice(8.88);
        book.setTitle("goosebumps");

        book = bookDao.add(book);
        assertEquals(book, bookDao.get(book.getId()));
        bookDao.delete(book.getId());
        assertNull(bookDao.get(book.getId()));
    }
    @Test
    public void getAllBook() {
        Book book = new Book();
        book.setAuthorId(author.getId());
        book.setIsbn("6666666XXX");
        book.setPublisherDate(LocalDate.of(1999, 10, 11));
        book.setPublisherId(publisher.getId());
        book.setPrice(8.88);
        book.setTitle("goosebumps");

        bookDao.add(book);

        book = new Book();
        book.setAuthorId(author.getId());
        book.setIsbn("666666MMS");
        book.setPublisherDate(LocalDate.of(1999, 10, 11));
        book.setPublisherId(publisher.getId());
        book.setPrice(8.88);
        book.setTitle("The shining");

        bookDao.add(book);

        assertEquals(2, bookDao.getAll().size());
    }
    @Test
    public void updateBook() {
        Book book = new Book();
        book.setAuthorId(author.getId());
        book.setIsbn("777777MMM");
        book.setPublisherDate(LocalDate.of(1999, 10, 11));
        book.setPublisherId(publisher.getId());
        book.setPrice(8.88);
        book.setTitle("The raven");

        Book bookFromDB = bookDao.add(book);

        bookFromDB.setPrice(9.99);
        bookDao.update(bookFromDB);

        assertEquals(bookFromDB, bookDao.get(bookFromDB.getId()));
    }
    @Test
    public void getBookByAuthorId() {
        Book book = new Book();
        book.setAuthorId(author.getId());
        book.setIsbn("6666666XXX");
        book.setPublisherDate(LocalDate.of(1999, 10, 11));
        book.setPublisherId(publisher.getId());
        book.setPrice(8.88);
        book.setTitle("goosebumps");

        bookDao.add(book);

        book = new Book();
        book.setAuthorId(author.getId());
        book.setIsbn("666666MMS");
        book.setPublisherDate(LocalDate.of(1999, 10, 11));
        book.setPublisherId(publisher.getId());
        book.setPrice(8.88);
        book.setTitle("The shining");

        bookDao.add(book);

        assertEquals(2, bookDao.findByAuthorId(author.getId()).size());
    }


    }
