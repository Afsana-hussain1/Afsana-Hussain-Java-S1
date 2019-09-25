package com.company;
import java.util.Scanner;

public class DoubleAndAddFive {

    public static void main(String[] args) {
     Scanner scan = new Scanner(System.in);

     int numEntered;

        System.out.println("Type in a number");
        numEntered = scan.nextInt();

        System.out.println((numEntered * 2) + 5);

    }
}
