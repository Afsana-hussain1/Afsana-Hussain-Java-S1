package com.example.afsanaHussainU1M5Summative.models;

import java.time.LocalDate;
import java.util.Objects;

public class Publisher {
    private int id;
    private String name;
    private String city;
    private String street;
    private String state;
    private String postalCode;
    private String Phone;
    private String email;
    private LocalDate publishDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDate publishDate) {
        this.publishDate = publishDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Publisher publisher = (Publisher) o;
        return getId() == publisher.getId() &&
                Objects.equals(getName(), publisher.getName()) &&
                Objects.equals(getCity(), publisher.getCity()) &&
                Objects.equals(getStreet(), publisher.getStreet()) &&
                Objects.equals(getState(), publisher.getState()) &&
                Objects.equals(getPostalCode(), publisher.getPostalCode()) &&
                Objects.equals(getPhone(), publisher.getPhone()) &&
                Objects.equals(getEmail(), publisher.getEmail()) &&
                Objects.equals(getPublishDate(), publisher.getPublishDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getCity(), getStreet(), getState(), getPostalCode(), getPhone(), getEmail(), getPublishDate());
    }
}
