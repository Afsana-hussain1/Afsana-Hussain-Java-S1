package com.company;

import java.util.Scanner;

public class AlittleQuiz {
    public static void main(String[] args) {

        System.out.println("Are you ready for a quiz?");
        System.out.println("Okay, here it comes!");

        System.out.println("Q1)" + "What is the capital of alaska?");
        System.out.println("1)" + "Melbourne");
        System.out.println("2)" + "Anchorage");
        System.out.println("3)" + "Juneau");

        Scanner myScanner= new Scanner(System.in);
        int userEnters = myScanner.nextInt();
        int answersCorrect =0;

        if(userEnters == 3) {
            System.out.println("Thats right!");
            answersCorrect++;

        }else {
            System.out.println("Wrong answer!");
        }

        System.out.println("Q2)"+ "Can you store the value 'cat' in a variable of type int?");
        System.out.println("1)"+ "Yes");
        System.out.println("2)" + "No");

        int numberEntered =myScanner.nextInt();

        if (numberEntered == 2) {
            System.out.println("Thats right!");
            answersCorrect++;
        }else{
            System.out.println("Sorry, 'Cat' is a string. ints can only store numbers");
        }
        System.out.println("Q3" +"What is the result of 9+6/3?");
        System.out.println("1)"+"5");
        System.out.println("2)"+"11");
        System.out.println("3)"+"15/3");

        int resultEntered =myScanner.nextInt();
        if(resultEntered ==2){
            System.out.println("Thats correct!");
            answersCorrect++;
        }else {
            System.out.println("Wrong answer!");
        }
        System.out.println("Overall, you got a " + answersCorrect + "out of 3 correct");
        System.out.println("Thanks for playing!");
    }



}
