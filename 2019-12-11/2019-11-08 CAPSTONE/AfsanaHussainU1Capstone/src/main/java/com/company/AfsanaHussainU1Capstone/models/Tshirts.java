package com.company.AfsanaHussainU1Capstone.models;

import java.math.BigDecimal;
import java.util.Objects;

public class Tshirts {
    private int TShirtId;
    private String size;
    private String color;
    private  String description;
    private BigDecimal price;
    private int quantity;

    public int getTShirtId() {
        return TShirtId;
    }

    public void setTShirtId(int TShirtId) {
        this.TShirtId = TShirtId;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tshirts tshirts = (Tshirts) o;
        return getTShirtId() == tshirts.getTShirtId() &&
                getQuantity() == tshirts.getQuantity() &&
                Objects.equals(getSize(), tshirts.getSize()) &&
                Objects.equals(getColor(), tshirts.getColor()) &&
                Objects.equals(getDescription(), tshirts.getDescription()) &&
                Objects.equals(getPrice(), tshirts.getPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTShirtId(), getSize(), getColor(), getDescription(), getPrice(), getQuantity());
    }
}
