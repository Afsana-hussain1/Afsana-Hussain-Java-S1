package com.company.abstractapproach;

public abstract class Square extends Shape {


    public double perimeter() {
        double sideLength = 0.0d;
        double perimeter= 4 * sideLength;
        return perimeter;


    }

    @Override
    public double area() {
        double side =0.0d;
        double area = side * side;
        return area;
    }
}

