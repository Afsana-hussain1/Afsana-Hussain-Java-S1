package com.company;
import java.util.Scanner;

public class SpaceBoxing {

    public static void main(String[] args) {
        System.out.println("Please enter your current earth weight");
        Scanner myScanner = new Scanner(System.in);
        double earthWeight = Integer.parseInt(myScanner.nextLine());

        System.out.println("I have information for the following planets:");
        System.out.println("1.venus" + "2. Mars" + "3.Jupiter");
        System.out.println("4. Saturn" + "5.Uranus" + "6.Neptune");

        System.out.println("Which planet are you visiting?");
        double  planetNumber = myScanner.nextDouble();
        double newWeight = 0;
        double venus = 1;
        double saturn = 4;
        double mars = 2;
        double jupiter = 3;
        double uranus = 5;
        double neptune = 6;
        if (planetNumber == 1) {
            newWeight = earthWeight * 0.78;

        } else if (planetNumber == 2) {
            newWeight = earthWeight * 0.39;
        } else if (planetNumber == 3) {
            newWeight = earthWeight * 2.65;
        } else if (planetNumber == 4) {
            newWeight = earthWeight * 1.17;
        } else if (planetNumber == 5) {
            newWeight = earthWeight * 1.05;
        } else if (planetNumber == 6) {
            newWeight = earthWeight * 1.23;

        }
        System.out.println("Your weight would be " + newWeight + " pounds on that planet");

    }
}
