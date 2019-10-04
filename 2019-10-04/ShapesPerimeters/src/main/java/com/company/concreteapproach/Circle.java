package com.company.concreteapproach;


import com.company.concreteapproach.Shape;

public class Circle extends Shape {

    @Override
    public double area() {
        double radius =0.0d;
        double area = Math.PI * (radius * radius);
        return area;
    }

    @Override
    public double perimeter() {
        double radius= 0.0d ;
        double perimeter = 2 * Math.PI * radius;
        return perimeter;
    }
}
