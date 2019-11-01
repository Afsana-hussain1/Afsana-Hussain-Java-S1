package com.example.afsanaHussainU1M5Summative.dao;


import com.example.afsanaHussainU1M5Summative.models.Book;

import java.util.List;

public interface BookDao {
    Book add(Book book);

    List<Book> getAll();

    Book get(int id);

    void update(Book book);

    void delete(int id);

    List<Book> findByAuthorId(int authorId);
}
