package com.company;

import java.util.Scanner;

public class EvenOrOdd {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Enter a number");
        int num1 = Integer.parseInt(myScanner.nextLine());
        if(num1 %2 ==0){
            System.out.println("it is an even number");
        } else{
            System.out.println("it is an odd number");
        }

    }
}
