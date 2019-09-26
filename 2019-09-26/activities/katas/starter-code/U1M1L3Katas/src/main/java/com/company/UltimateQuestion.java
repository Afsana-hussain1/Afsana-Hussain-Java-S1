package com.company;

import java.util.Scanner;

public class UltimateQuestion {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        int numberEntered;
        do {
            System.out.println("Please enter a number from 1 to 100");
            numberEntered = Integer.parseInt(myScanner.nextLine());
        } while ( numberEntered != 42);
        System.out.println("That's the number I was looking for! 42 is definitely the answer!");
    }
}
