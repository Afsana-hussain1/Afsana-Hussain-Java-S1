package com.example.afsanaHussainU1M5Summative.dao;

import com.example.afsanaHussainU1M5Summative.models.Publisher;

import java.time.LocalDate;
import java.util.List;

public interface PublisherDao {

    Publisher add(Publisher publisher);

    List<Publisher> getAll();

    Publisher get(int id);

    void update(Publisher publisher);

    void delete(int id);

}
