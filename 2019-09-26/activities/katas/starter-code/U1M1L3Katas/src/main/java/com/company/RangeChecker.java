package com.company;

import java.util.Scanner;

public class RangeChecker {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        int numberEntered;
        do {
            System.out.println("Please enter a number from 15 to 32");
           numberEntered = Integer.parseInt(myScanner.nextLine());
        } while ( numberEntered < 15 || numberEntered > 32);
        System.out.println(numberEntered);
    }
}
