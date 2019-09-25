package com.company;

import java.util.Scanner;

public class RectPavingCompany {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

       int Length1;
        int width1;
       int area;
       int perimeter;
        float costFootersPerLinearFoot = 8.25f;
        float perSqFtCostCement =  12.50f;
        float TotalCostOfCement;
       float TotalCostOfFraming;
        float UserEntersCementCost;
       float UserEntersFraming;
       float TotalCostOfCement2;
       float TotalCostOfFraming2;

        //user enters data to calculate area
        System.out.println("Enter length of driveway to calculate area ");
        Length1 = Integer.parseInt(scan.nextLine());
        System.out.println("Enter width of driveway to calculate area");
        width1 = Integer.parseInt(scan.nextLine());
        area = width1 * Length1;
        System.out.println( "The area of driveway:" + area);


//        //user enters data to calculate perimeter
//        System.out.println("Enter length of driveway to calculate perimeter");
//        Length1 = Integer.parseInt(scan.nextLine());
//        System.out.println("Enter width of driveway to calculate perimeter");
//        width1 = Integer.parseInt(scan.nextLine());

        //displays perimeter
        perimeter =( Length1 + Length1 + width1 + width1);
        System.out.println("The perimeter of driveway:" + perimeter );

        //Calculates total cost of cement

        TotalCostOfCement = area * perSqFtCostCement;
        System.out.printf("The total cost of cement is %.2f.\n", TotalCostOfCement);

        //calculate cost of framing
        TotalCostOfFraming = costFootersPerLinearFoot * perimeter;
        System.out.printf("The total cost of framing is %.2f\n", TotalCostOfFraming);

        //version 2.0
        System.out.println( "Please enter cost of cement per square foot");
        UserEntersCementCost = Float.parseFloat(scan.nextLine());

        TotalCostOfCement2 = UserEntersCementCost * area;

        System.out.println("The total cost of cement Version 2 is" + TotalCostOfCement2 );

        System.out.println("Please enter cost of footers per linear foot");
        UserEntersFraming = Float.parseFloat(scan.nextLine());
        TotalCostOfFraming2 = UserEntersFraming * perimeter;

        System.out.println("the total cost of framing version 2 is" + TotalCostOfFraming2 );









    }
}
