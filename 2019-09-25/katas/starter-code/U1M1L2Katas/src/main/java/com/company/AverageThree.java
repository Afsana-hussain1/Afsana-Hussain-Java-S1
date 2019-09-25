package com.company;
import java.util.Scanner;

public class AverageThree {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        float num1;
        float num2;
        float num3;

        System.out.println("Type in a number");
        num1 = scan.nextFloat();

        System.out.println("Type in a second number");
        num2 = scan.nextFloat();

        System.out.println("Type in a third number and find the average !");
        num3 = scan.nextFloat();

        System.out.printf("%.2f",(num1 + num2 + num3) / 3);
    }
}




