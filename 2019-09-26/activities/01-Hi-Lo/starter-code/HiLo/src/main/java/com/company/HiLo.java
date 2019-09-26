package com.company;

import java.util.Scanner;
import java.util.Random;

public class HiLo {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Welcome to Hi-Low!");
        System.out.println("What is your name?");
        String UserName = myScanner.nextLine();
        System.out.println("OK, " + UserName +", here are the rules:");

        //generate the random number
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(100) + 1;

        System.out.println("Please enter a number");
        int UserNumber = Integer.parseInt(myScanner.nextLine());
        int UserGuesses = 0;
        while(UserNumber != randomInt) {
            if (UserNumber > randomInt) {
                System.out.println("Too high!");
            } else {
                System.out.println("Too low!");

            }
            System.out.println("try again!");
            UserNumber= Integer.parseInt(myScanner.nextLine());
            UserGuesses++;




        }
        System.out.println("Congratulations, " + UserName  + "! You win!");

        System.out.println("It took you "  + UserGuesses + " guesses to find my number!");


                }







    }

