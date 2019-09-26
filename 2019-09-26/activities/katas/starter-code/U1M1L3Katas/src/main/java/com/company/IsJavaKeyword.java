package com.company;

import java.util.Scanner;

public class IsJavaKeyword {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        System.out.println("Type in a word ");
        String userInput = myScanner.nextLine();
        boolean isJava =false;

        switch (userInput) {

            case "for":
                isJava = true;
                break;

            case "while":
                isJava = true;
                break;

        }
        if(isJava) {
            System.out.println("the input is a java keyword!");
        }else {
            System.out.println(" the input is not a java keyword!");
        }




    }
}
