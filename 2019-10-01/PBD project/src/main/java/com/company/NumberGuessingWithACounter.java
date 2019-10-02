package com.company;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessingWithACounter {
    public static void main(String[] args) {
        Random generateRand = new Random();
        int randomInt = generateRand.nextInt(10) + 1;
        Scanner myScanner =new Scanner(System.in);
        int numOfGuesses =0;


        System.out.println("I have chosen a number between 1 and 10. try to guess it");
        int yourGuess =  myScanner.nextInt();
        System.out.println("your guess: " + yourGuess);
         numOfGuesses++;

        while(yourGuess != randomInt) {
            System.out.println("that is incorrect guess again");
            yourGuess =myScanner.nextInt();
            numOfGuesses++;
        }
        System.out.println("Thats right!your a good guesser");
        System.out.println("It only took you " + numOfGuesses +" tries");
    }
}
