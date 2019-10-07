package com.company;

import java.util.Scanner;

public class BabyNim {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);


        int A = 3;
        int B = 3;
        int C = 3;

        int removePile = 0;

        while (A > 0 || B > 0 || C > 0) {
            System.out.println("Choose a pile");
            String userInput = myScanner.nextLine();
            if (userInput.equals("A")) {
                System.out.println("How many to remove from pile A");
                System.out.println("A: " + A + "\t" + "B: " + B + "\t" + "C: " + C);
                System.out.println();
                removePile = Integer.parseInt(myScanner.nextLine());
                A -= removePile;
                System.out.println("A: " + A + "\t" + "B: " + B + "\t" + "C: " + C);

            }
            if (userInput.equals("B")) {
                System.out.println("How many to remove from pile B");
                System.out.println("A: " + A + "\t" + "B: " + B + "\t" + "C: " + C);
                System.out.println();
                removePile = Integer.parseInt(myScanner.nextLine());
                B -= removePile;
                System.out.println("A: " + A + "\t" + "B: " + B + "\t" + "C: " + C);


            }
            if (userInput.equals("C")) {
                System.out.println("How many to remove from pile C");
                System.out.println("A: " + A + "\t" + "B: " + B + "\t" + "C: " + C);
                System.out.println();
                removePile = Integer.parseInt(myScanner.nextLine());
                C -= removePile;
                System.out.println("A: " + A + "\t" + "B: " + B + "\t" + "C: " + C);


            }

        }
        System.out.println("All piles are empty good job!");
    }
}
