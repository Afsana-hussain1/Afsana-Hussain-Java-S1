package com.company.concreteapproach;
import com.company.concreteapproach.Shape;

public class Square extends Shape {

    @Override
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
