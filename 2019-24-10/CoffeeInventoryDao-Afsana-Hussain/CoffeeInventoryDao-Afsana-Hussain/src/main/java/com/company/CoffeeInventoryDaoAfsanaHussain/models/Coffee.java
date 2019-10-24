package com.company.CoffeeInventoryDaoAfsanaHussain.models;

import java.util.Objects;

public class Coffee {
    private int id;
    private String name;
    private int count;
    private double unit_price;
    private String type;
    private String description;

public int getId () {
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

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(double unit_price) {
        this.unit_price = unit_price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coffee coffee = (Coffee) o;
        return id == coffee.id &&
                count == coffee.count &&
                Double.compare(coffee.unit_price, unit_price) == 0 &&
                Objects.equals(name, coffee.name) &&
                Objects.equals(type, coffee.type) &&
                Objects.equals(description, coffee.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, count, unit_price, type, description);
    }
}
