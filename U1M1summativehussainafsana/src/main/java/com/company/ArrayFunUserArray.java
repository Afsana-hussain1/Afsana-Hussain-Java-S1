package com.company;
import java.util.Scanner;

public class ArrayFunUserArray {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        System.out.println("Type in a  number!!");
        int numOne =Integer.parseInt(myScanner.nextLine());

        System.out.println("Type in a  number!!");
        int numTwo =Integer.parseInt(myScanner.nextLine());

        System.out.println("Type in a  number!!");
        int numThree=Integer.parseInt(myScanner.nextLine());

        System.out.println("Type in a  number!!");
        int numFour =Integer.parseInt(myScanner.nextLine());

        System.out.println("Type in a  number!!");
        int numFive =Integer.parseInt(myScanner.nextLine());

        int numArray[] ={numOne,numTwo,numThree,numFour,numFive};
        for(int x=0;x<numArray.length;x++)
            System.out.println(numArray[x] + ",");

    }

}
