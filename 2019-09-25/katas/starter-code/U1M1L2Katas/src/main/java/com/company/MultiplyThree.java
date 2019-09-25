package com.company;
import java.util.Scanner;

public class MultiplyThree {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num1;
        int num2;
        int num3;

        System.out.println("Type in a number");
        num1 = scan.nextInt();

        System.out.println("type in another number");
        num2 = scan.nextInt();

        System.out.println("type in a third number to multiply all three!");
        num3 = scan.nextInt();

        System.out.println(num1 * num2 * num3);
    }
}