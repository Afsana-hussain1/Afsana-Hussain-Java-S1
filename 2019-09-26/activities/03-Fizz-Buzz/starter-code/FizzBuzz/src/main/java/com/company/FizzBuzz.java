package com.company;

public class FizzBuzz {
    public static void main(String[] args) {
        for (int m = 1; m <= 100; m ++) {
            if(m % 3 == 0 && m % 5 ==0 ) {
                System.out.println("FIZZBUZZ");
            }else if (m % 3 ==0){
                System.out.println("FIZZ");
            } else if (m % 5 == 0){
                System.out.println("BUZZ");
            }else {
                System.out.println(m);
            }
        }
    }
}