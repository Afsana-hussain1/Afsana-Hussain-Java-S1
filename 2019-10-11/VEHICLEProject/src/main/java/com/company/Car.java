package com.company;
import java.util.Objects;

public class Car {

        private String make;
        private String model;
        private int year;
        private String color;
        private int milesOnOdometer;

    public Car(String make, String model, int year, String color, int milesOnOdometer) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
        this.milesOnOdometer = milesOnOdometer;
    }

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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getMilesOnOdometer() {
        return milesOnOdometer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return year == car.year &&
                milesOnOdometer == car.milesOnOdometer &&
                Objects.equals(make, car.make) &&
                Objects.equals(model, car.model) &&
                Objects.equals(color, car.color);
    }

    public void setMilesOnOdometer(int milesOnOdometer) {
        this.milesOnOdometer = milesOnOdometer;

    }

    @Override
    public int hashCode() {
        return Objects.hash(make,model,year,color,milesOnOdometer);
    }

    @Override
    public String toString() {
        return "Make:" + make + "model" + model + "miles on odometer" + milesOnOdometer + "year" + year;
    }

    public void setMiles(int miles) {
        this.milesOnOdometer = miles;



    }
}
