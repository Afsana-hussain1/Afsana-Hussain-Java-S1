package com.company;

public class Sedan extends Car{

    @Override
    public void displayMilesTraveled() {
        super.displayMilesTraveled();
    }

    @Override
    public void drive(int miles) {
        super.drive(miles);
    }

    public String make;
    public  String model;

    public int numDoors;
    public boolean poweredWindows;

    @Override
    public String getMake() {
        return make;
    }

    @Override
    public void setMake(String make) {
        this.make = make;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public void setModel(String model) {
        this.model = model;
    }

    public int getNumDoors() {
        return numDoors;
    }

    public void setNumDoors(int numDoors) {
        this.numDoors = numDoors;
    }

    public boolean isPoweredWindows() {
        return poweredWindows;
    }

    public void setPoweredWindows(boolean poweredWindows) {
        this.poweredWindows = poweredWindows;
    }
}
