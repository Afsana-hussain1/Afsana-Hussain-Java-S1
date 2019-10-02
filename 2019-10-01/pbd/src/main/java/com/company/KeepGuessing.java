package com.company;

import java.util.Random;
import java.util.Scanner;

public class KeepGuessing {
    public static void main(String[] args) {
        Random generateRand = new Random();
        int randomInt = generateRand.nextInt(10) + 1;
        Scanner myScanner =new Scanner(System.in);


        System.out.println("I have chosen a number between 1 and 10. try to guess it");
        int yourGuess =  myScanner.nextInt();
        System.out.println("your guess: " + yourGuess);


        while(yourGuess != randomInt) {
            System.out.println("that is incorrect guess again");
            yourGuess =myScanner.nextInt();
        }
        System.out.println("Thats right!your a good guesser");
    }
}
