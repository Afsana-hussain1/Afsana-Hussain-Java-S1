package com.company;
import java.util.Scanner;

public class MonthConverterIf {
    public static void main(String[] args) {
        System.out.println( "Please Enter A number from 1-12");
        Scanner myScanner = new Scanner(System.in);
        int userInput = Integer.parseInt(myScanner.nextLine());


        if(userInput <1 || userInput >12) {
            System.out.println("You have entered an invalid number. You must enter a number between 1 and 12. Goodbye");
        }else if (userInput == 1){
            System.out.println("January");

        }else if(userInput ==2){
            System.out.println("February");

        } else if(userInput == 3){
            System.out.println("March");

        }else if (userInput == 4){
            System.out.println("April");
        }else if(userInput==5){
            System.out.println("may");
        }else if(userInput == 6){
            System.out.println("june");
        }else if(userInput == 7) {
            System.out.println("july");
        }else if(userInput == 8){
            System.out.println("August");
        }else if(userInput == 9){
            System.out.println("September");
        }else if(userInput == 10){
            System.out.println("October");
        }else if(userInput == 11){
            System.out.println("november");
        }else if(userInput == 12) {
            System.out.println("December");
        }


    }


}


