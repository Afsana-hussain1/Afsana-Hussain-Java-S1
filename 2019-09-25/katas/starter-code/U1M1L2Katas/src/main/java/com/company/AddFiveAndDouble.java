package com.company;

import java.util.Scanner;

public class AddFiveAndDouble {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int UserNumber;
        System.out.println("enter a number");
        UserNumber = scan.nextInt();

        System.out.println((UserNumber + 5)* 2);

    }
}
