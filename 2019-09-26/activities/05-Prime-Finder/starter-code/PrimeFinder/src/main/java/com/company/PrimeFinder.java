package com.company;
import java.util.Scanner;

public class PrimeFinder {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Enter a number");
        int userNumber = Integer.parseInt(myScanner.nextLine());

        for (int i = 1; i <= userNumber; i++) {
            if (isPrime(i)) {
                System.out.println(i);
            }
        }

    }

    static boolean isPrime(int n)
    {
        // Corner case
        if (n <= 1)
            return false;

        // Check from 2 to n-1
        for (int i = 2; i < n; i++)
            if (n % i == 0)
                return false;

        return true;
    }
}






