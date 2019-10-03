package com.company;

import com.company.interfaces.UserIO;

import java.util.Scanner;

public class Input implements UserIO {

    @Override
    public double readDouble(String prompt) {
        System.out.println(prompt);
        Scanner myScanner = new Scanner(System.in);
        String UserInput =myScanner.nextLine();
        double y = Double.parseDouble(UserInput);
        return y;
    }

    @Override
    public float readFloat(String prompt) {
        System.out.println(prompt);
        Scanner myScanner = new Scanner(System.in);
        String UserInput = myScanner.nextLine();
        float x = Float.parseFloat(UserInput);
        return x;

    }

    @Override
    public int readInt(String prompt) {
        System.out.println(prompt);
        Scanner myScanner = new Scanner(System.in);
        String UserInput = myScanner.nextLine();
        int m = Integer.parseInt(UserInput);
        return m;


    }

    @Override
    public long readLong(String prompt) {
        System.out.println(prompt);
        Scanner myScanner = new Scanner(System.in);
        String UserInput = myScanner.nextLine();
        Long n = Long.parseLong(UserInput);
        return n;
    }

    @Override
    public String readString(String prompt) {
        System.out.println(prompt);
        Scanner myScanner = new Scanner(System.in);
        String UserInput = myScanner.nextLine();
        return UserInput;
    }
}
