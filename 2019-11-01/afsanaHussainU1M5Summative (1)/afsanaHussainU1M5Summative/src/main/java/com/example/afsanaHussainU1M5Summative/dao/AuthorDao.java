package com.example.afsanaHussainU1M5Summative.dao;


import com.example.afsanaHussainU1M5Summative.models.Author;

import java.util.List;

public interface AuthorDao {

    Author add(Author author);

    List<Author> getAll();

    Author get(int id);

    void update(Author author);

    void delete(int id);
}
