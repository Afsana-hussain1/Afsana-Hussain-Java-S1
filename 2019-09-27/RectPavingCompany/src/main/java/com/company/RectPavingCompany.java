package com.company; //Look on bottom for comments
import java.util.Scanner;

public class RectPavingCompany {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.print("What is the width of the driveway in feet? ");
        int width = Integer.parseInt(scan.nextLine());

        System.out.print("What is the length of the driveway in feet? ");
        int length = Integer.parseInt(scan.nextLine());

        float cementCost = 0.0f;
        float framingCost = 0.0f;

        System.out.print("What is the cost of cement per square foot? ");
        cementCost = Float.parseFloat(scan.nextLine());

        System.out.print("What is the cost of framing/footers per linear foot? ");
        framingCost = Float.parseFloat(scan.nextLine()); //cementCost to framingCost

        int area = length * width;
        int perimeter = 2*length + 2*width; //changed subtraction to addition

       System.out.format("The area of the driveway is %d square feet.%n", area);
       System.out.format("The perimeter of the driveway is %d square feet.%n", perimeter);

        System.out.format("The cost of the cement is %.2f%n", area*cementCost); //added 2 to %f
        System.out.format("The cost of the framing/footers is %.2f%n", perimeter*framingCost); //added 2 to %f
        //changed from perimeter + framingCost to perimeter * framingCost
    }
}
/*
Line # 26 : changed subtraction to addition
Line # 31 : added 2 to %f
Line #32 :changed from perimeter + framingCost to perimeter * framingCost AND added 2 to %f.
Line #23: Changed from cementCost to framingCost
*/