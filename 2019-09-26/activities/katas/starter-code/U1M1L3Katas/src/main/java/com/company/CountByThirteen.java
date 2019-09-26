package com.company;

import java.util.Scanner;

public class CountByThirteen {

    public static void main(String[] args) {
        Scanner myscanner = new Scanner(System.in);

        System.out.println("Enter a number:");
        int num1 = Integer.parseInt(myscanner.nextLine());

        int i = 0;

        while (i < num1 + 1) {
            System.out.println(i);
            i = i + 13;
        }
    }

}