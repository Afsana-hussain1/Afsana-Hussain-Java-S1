package com.company;

import java.util.Scanner;


public class YourAgeCan {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Enter your age");
        int age1 = Integer.parseInt(myScanner.nextLine());

        if (age1 >= 18 && age1 <=20) {
         System.out.println("Drink alcohol");

        } else if (age1 >= 21 && age1 <=34) {
            System.out.println("Vote and Drink alcohol!");
        } else if (age1 >= 35 && age1 <= 54) {
            System.out.println("Vote, Drink alcohol, and Be president");

        } else if (age1 >= 55 && age1 <= 64) {
            System.out.println(" Vote, Drink alcohol and , Is eligible for AARP");

        } else if (age1 >= 65 && age1 <= 79) {
            System.out.println("Can retire, Is eligble for AARP, Can vote, Drink alcohol, and be president");
        } else if (age1 >= 80 && age1 <= 89) {
            System.out.println("Is an octogenarian, Can retire, Is eligible for AARP, Be president, Drink alcohol and Vote");
        } else if (age1 >= 100) {
            System.out.println("Is more than a century old, Is an octogenarian, Can retire,  Is eligible for AARP, Be president, Drink alcohol and Vote");


        }
    }

}