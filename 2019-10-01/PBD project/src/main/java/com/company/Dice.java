package com.company;

import java.util.Random;

public class Dice {
    public static void main(String[] args) {
        Random generateRand = new Random();
        int diceOne = generateRand.nextInt(6) + 1;
        System.out.println("Roll # 1: " + diceOne);

        Random generateRand2 = new Random();
        int diceTwo = generateRand2.nextInt(6)+1;
        System.out.println("Roll # 2: " + diceTwo);

        System.out.println("The total is " + (diceOne+diceTwo)+"!");
    }
}
