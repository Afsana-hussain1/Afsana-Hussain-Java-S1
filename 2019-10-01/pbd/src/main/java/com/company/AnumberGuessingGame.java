package com.company;
import java.util.Scanner;
import java.util.Random;

public class AnumberGuessingGame {
    public static void main(String[] args) {
        Random generateRand = new Random();
        int randomInt = generateRand.nextInt(10) + 1;
        Scanner myScanner =new Scanner(System.in);


        System.out.println("I'm thinking of a number from 1 to 10");
        int yourGuess =  myScanner.nextInt();
        System.out.println("Your guess " +yourGuess);


        if( yourGuess == randomInt) {

            System.out.println("That's right! my secret number was" + yourGuess);
        }else {
            System.out.println("Sorry, but I was really thinking of " + randomInt);
        }
    }
}
