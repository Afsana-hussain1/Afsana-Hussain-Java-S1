package com.company;

import java.util.Random;
import java.util.Scanner;

public class FortuneCookie {
    public static void main(String[] args) {
        Random generateRand = new Random();
        int fortuneNum = generateRand.nextInt(6) + 1;

        if (fortuneNum == 1) {
            System.out.println("Fortune cookie says : you will live a long life");
        } else if (fortuneNum == 2) {
            System.out.println("Fortune cookie says : you will be rich ");
        } else if (fortuneNum == 3) {
            System.out.println("Fortune cookie says : you will travel the world ");
        } else if (fortuneNum == 4) {
            System.out.println("Fortune cookie says : you will travel the world ");
        } else if (fortuneNum == 5) {
            System.out.println("Fortune cookie says : you will have a son ");
        } else if (fortuneNum == 6) {
            System.out.println("Fortune cookie says : you will have a daughter ");
        }
    }
}
