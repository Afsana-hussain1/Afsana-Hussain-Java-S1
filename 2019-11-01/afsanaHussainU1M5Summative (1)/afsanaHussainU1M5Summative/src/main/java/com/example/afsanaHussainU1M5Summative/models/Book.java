package com.example.afsanaHussainU1M5Summative.models;

import java.time.LocalDate;
import java.util.Objects;

public class Book {
    private int id;
    private String isbn;
    private LocalDate publisherDate;
    private int authorId;
    private String title;
    private int publisherId;
    private double price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public LocalDate getPublisherDate() {
        return publisherDate;
    }

    public void setPublisherDate(LocalDate publisherDate) {
        this.publisherDate = publisherDate;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(int publisherId) {
        this.publisherId = publisherId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return getId() == book.getId() &&
                getAuthorId() == book.getAuthorId() &&
                getPublisherId() == book.getPublisherId() &&
                Double.compare(book.getPrice(), getPrice()) == 0 &&
                Objects.equals(getIsbn(), book.getIsbn()) &&
                Objects.equals(getPublisherDate(), book.getPublisherDate()) &&
                Objects.equals(getTitle(), book.getTitle());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getIsbn(), getPublisherDate(), getAuthorId(), getTitle(), getPublisherId(), getPrice());
    }
}


