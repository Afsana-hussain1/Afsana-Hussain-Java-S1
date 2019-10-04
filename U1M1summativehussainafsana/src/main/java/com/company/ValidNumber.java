package com.company;
import java.util.Scanner;
public class ValidNumber {

    public static void main(String[] args) {
        System.out.println("Please enter a number between 1 and 10 ");
        Scanner myScanner = new Scanner(System.in);
        int userInput = Integer.parseInt(myScanner.nextLine());

        while(userInput <1 || userInput > 10 ){
            System.out.println("You must enter a number between 1 and 10, please try again.");
            userInput = Integer.parseInt(myScanner.nextLine());
        }
        System.out.println(userInput);
    }
}


