package com.company;

import java.util.Scanner;

public class Nim {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        int A = 5;
        int B = 5;
        int C = 5;

        int removePile1 = 0;
        int removePile2 = 0;

        String player1 = "";
        System.out.println("Player 1, enter your name:" + player1);
        player1 = myScanner.nextLine();
        System.out.println("Player 1, enter your name:" + player1);

        String player2 = "";
        System.out.println("Player 2, enter your name:" + player2);
        player2 = myScanner.nextLine();
        System.out.println("Player 2, enter your name:" + player2);


        while (A > 0 || B > 0 || C > 0) {
            System.out.println(player1 + "Choose your pile");
            String userInput1 = myScanner.nextLine();
            if (userInput1.equals("A")) {
                System.out.println("How many to remove from pile A");
                System.out.println("A: " + A + "\t" + "B: " + B + "\t" + "C: " + C);
                System.out.println();
                removePile1 = Integer.parseInt(myScanner.nextLine());
                A -= removePile1;
                System.out.println("A: " + A + "\t" + "B: " + B + "\t" + "C: " + C);
            }
            if (userInput1.equals("B")) {
                System.out.println("How many to remove from pile B");
                System.out.println("A: " + A + "\t" + "B: " + B + "\t" + "C: " + C);
                System.out.println();
                removePile1 = Integer.parseInt(myScanner.nextLine());
                B -= removePile1;
                System.out.println("A: " + A + "\t" + "B: " + B + "\t" + "C: " + C);
            }
            if (userInput1.equals("C")) {
                System.out.println("How many to remove from pile C");
                System.out.println("A: " + A + "\t" + "B: " + B + "\t" + "C: " + C);
                System.out.println();
                removePile1 = Integer.parseInt(myScanner.nextLine());
                C -= removePile1;
                System.out.println("A: " + A + "\t" + "B: " + B + "\t" + "C: " + C);
            }


            System.out.println(player2 + "Choose your pile");
            String userInput2 = myScanner.nextLine();
            switch (userInput2) {
                case "A":
                    System.out.println("How many to remove from pile A");
                    System.out.println("A: " + A + "\t" + "B: " + B + "\t" + "C: " + C);
                    System.out.println();
                    removePile1 = Integer.parseInt(myScanner.nextLine());
                    A -= removePile1;
                    System.out.println("A: " + A + "\t" + "B: " + B + "\t" + "C: " + C);
                    break;

                case "B":
                    System.out.println("How many to remove from pile B");
                    System.out.println("A: " + A + "\t" + "B: " + B + "\t" + "C: " + C);
                    System.out.println();
                    removePile1 = Integer.parseInt(myScanner.nextLine());
                    B -= removePile1;
                    System.out.println("A: " + A + "\t" + "B: " + B + "\t" + "C: " + C);
                    break;

                case "C":
                    System.out.println("How many to remove from pile C");
                    System.out.println("A: " + A + "\t" + "B: " + B + "\t" + "C: " + C);
                    System.out.println();
                    removePile1 = Integer.parseInt(myScanner.nextLine());
                    C -= removePile1;
                    System.out.println("A: " + A + "\t" + "B: " + B + "\t" + "C: " + C);
                    break;


            }

            }


        }
    }





