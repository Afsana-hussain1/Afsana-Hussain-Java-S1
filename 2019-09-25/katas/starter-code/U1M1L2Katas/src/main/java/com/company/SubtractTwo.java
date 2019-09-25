package com.company;
import java.util.Scanner;

public class SubtractTwo {

    public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);

      int num1;
      int num2;

        System.out.println("type a number");
        num1 = scan.nextInt();

        System.out.println("typ another number to subtract!");
        num2 = scan.nextInt();

        System.out.println(num1 - num2);
    }
}
