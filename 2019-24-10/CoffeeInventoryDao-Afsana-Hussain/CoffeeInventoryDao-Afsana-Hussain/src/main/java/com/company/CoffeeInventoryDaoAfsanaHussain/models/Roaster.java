package com.company.CoffeeInventoryDaoAfsanaHussain.models;

import java.util.Objects;

public class Roaster {
    private int id;
    private String  name;
    private String Street;
    private String email;
    private String note;
    private String city;
    private String postal_code;

    public int getid () {

        return id;
    }

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

    public String getStreet() {
        return Street;
    }

    public void setStreet(String street) {
        Street = street;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Roaster roaster = (Roaster) o;
        return id == roaster.id &&
                Objects.equals(name, roaster.name) &&
                Objects.equals(Street, roaster.Street) &&
                Objects.equals(email, roaster.email) &&
                Objects.equals(note, roaster.note) &&
                Objects.equals(city, roaster.city) &&
                Objects.equals(postal_code, roaster.postal_code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, Street, email, note, city, postal_code);
    }
}
