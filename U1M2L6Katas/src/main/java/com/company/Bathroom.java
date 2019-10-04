package com.company;

public class Bathroom extends Home {

    private boolean Hasbathroom;
    private  float SquareFeet;

    public boolean isHasbathroom() {
        return Hasbathroom;
    }

    public void setHasbathroom(boolean hasbathroom) {
        Hasbathroom = hasbathroom;
    }

    public float getSquareFeet() {
        return SquareFeet;
    }

    public void setSquareFeet(float squareFeet) {
        SquareFeet = squareFeet;
    }
}
