package com.company;

public class Accord extends Sedan {
    @Override
    public void drive(int miles) {
        super.drive(miles);
    }

    @Override
    public void displayMilesTraveled() {
        super.displayMilesTraveled();
    }

    @Override
    public boolean isPoweredWindows() {
        return super.isPoweredWindows();
    }

    @Override
    public int getNumDoors() {
        return super.getNumDoors();
    }

    @Override
    public String getMake() {
        return super.getMake();
    }

    @Override
    public String getModel() {
        return super.getModel();
    }

    @Override
    public void setMake(String make) {
        super.setMake(make);
    }

    @Override
    public void setModel(String model) {
        super.setModel(model);
    }

    @Override
    public void setNumDoors(int numDoors) {
        super.setNumDoors(numDoors);
    }

    @Override
    public void setPoweredWindows(boolean poweredWindows) {
        super.setPoweredWindows(poweredWindows);
    }

    private String year;
    private Engine engine;
    private Transmission transmission;

    public Engine getEngine() {
        return engine;
    }

    public String getYear() {
        return year;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    public void setYear(String year) {
        this.year = year;
    }

}
