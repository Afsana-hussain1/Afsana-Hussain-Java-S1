package com.company;
import java.util.Random;
import java.util.Scanner;

public class HiLoWithLimitedTries {
    public static void main(String[] args) {

        Scanner myScanner = new Scanner(System.in);
        System.out.println("Im thinking of a number between 1-100. you have 7 guesses");

        int UserGuess = myScanner.nextInt();
        System.out.println(" first Guess: " + UserGuess);


        //generate the random number
        Random generateRand = new Random();
        int randomInt = generateRand.nextInt(100) + 1;


        int timesGuessed = 1;
        while (UserGuess != randomInt && timesGuessed < 7) {
            if (UserGuess > randomInt) {
                System.out.println("Sorry, that guess is Too high!");
                System.out.println("Guess #" + timesGuessed + ":");
                UserGuess = myScanner.nextInt();
                timesGuessed++;
            } else {
                System.out.println("Sorry you are too low!");
                System.out.println("Guess #" + timesGuessed + ":");
                UserGuess = myScanner.nextInt();
                timesGuessed++;
            }


        }
        System.out.println("Guess # :" + timesGuessed);

        if (UserGuess == randomInt) {
            System.out.println("you guessed it! what are the odds?");


        } else {
            System.out.println("Sorry, you didn't guess it in " + timesGuessed + " tries you lose");
        }
    }
}
