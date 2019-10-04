package com.company;

import com.company.Interfaces.Vehicle;

public class Car implements Vehicle {

    @Override
    public void displayMilesTraveled() {

    }

    @Override
    public void drive(int miles) {

    }

    private String make;
    private String model;

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
