package com.company;
import java.util.Scanner;

public class AddFive {
    public static void main(String[] args) {
                Scanner scan = new Scanner(System.in);

                int num1;
                int num2;
                int num3;
                int num4;
                int num5;

                System.out.println("Type in a number");
                num1 = scan.nextInt();

                System.out.println("Type in a second number");
                num2 = scan.nextInt();

                System.out.println("Type in a third number");
                num3 = scan.nextInt();

               System.out.println("Type in a fourth number");
               num4 = scan.nextInt();

               System.out.println("Type in a fifth number to calculate the sum !");
               num5 = scan.nextInt();

                System.out.println(num1 + num2 + num3 +num4 + num5);
            }
        }







