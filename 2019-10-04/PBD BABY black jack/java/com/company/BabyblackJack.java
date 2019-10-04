package com.company;

import java.util.Random;

public class BabyblackJack {
    public static void main(String[] args) {
        System.out.println("baby BlackJack!!");
        Random generateRand= new Random();
       int cardOne = generateRand.nextInt(9)+1;
       int cardTwo =generateRand.nextInt(9)+1;

        System.out.println("you drew" + cardOne + "and" +cardTwo);
        System.out.println("your total is" + (cardOne + cardTwo + "."));
        int cardDlr1 =generateRand.nextInt(9)+1;
        int cardDlr2 =generateRand.nextInt(9)+1;
        System.out.println("the dealer has" + cardDlr1 + "and" + cardDlr2 + ".");

        if(cardDlr1+cardDlr2 > cardOne + cardTwo) {
            System.out.println("dealer wins!!");
        }
        else{
            System.out.println("you win!!");
        }
    }
}
