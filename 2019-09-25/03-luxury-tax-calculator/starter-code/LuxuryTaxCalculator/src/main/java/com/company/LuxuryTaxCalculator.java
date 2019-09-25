package com.company;
import java.util.Scanner;

public class LuxuryTaxCalculator {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int Player1Salary;
        int Player2Salary;
        int Player3Salary;
        int SumOfSalaries;
        double TaxRate = 0.18;
        double SpendingLimit;
        double OverLimitSpent;


        System.out.println("Enter player1 salary");
        Player1Salary = Integer.parseInt(scan.nextLine());

        System.out.println("Enter player2 salary");
        Player2Salary = Integer.parseInt(scan.nextLine());

        System.out.println("Enter Player3 Salary");
        Player3Salary = Integer.parseInt(scan.nextLine());

        SumOfSalaries = Player1Salary + Player2Salary + Player3Salary;
        System.out.println(SumOfSalaries);
        SpendingLimit = 40000000;


        if (SumOfSalaries > SpendingLimit){
            OverLimitSpent = SumOfSalaries - SpendingLimit;
            System.out.println(OverLimitSpent * TaxRate);
        }



    }
}
