package com.company.concreteapproach;
import com.company.concreteapproach.Shape;
public class Triangle extends Shape {

    @Override
    public double perimeter() {
        double side1 =0.0d;
        double side2 =0.0d;
        double side3 =0.0d;
        double perimeter = side1+side2+side3;
        return perimeter;
    }

    @Override
    public double area() {
        double base =0.0d;
        double height = 0.0d;
      double area=  (base*height)/2;

        return area;
    }
}
