package com.company;
import java.util.Scanner;
public class AgeAgain {


    public static void main(String[] args) {
        Scanner myScanner =  new Scanner(System.in);

        System.out.println("How old are you?");
        int userInput = Integer.parseInt(myScanner.nextLine());
        if(userInput < 14){
            System.out.println("what grade are you in?");
            String GradeEntered = myScanner.nextLine();
            System.out.println("Wow! " +  GradeEntered  + " grade - that sounds exciting!");

        } else if (userInput <= 18){
            System.out.println("Are you planning to go to college? yes or No");
           String CollegeDecision = myScanner.nextLine();
            if (CollegeDecision.equals("yes")){
                System.out.println("Which college?");
                String CollegeEntered = myScanner.nextLine();
                System.out.println(CollegeEntered + " is a great school!");

            } else if (CollegeDecision.equals("no")) {
                System.out.println("what do you want to do after high school?");
                String AfterHS = myScanner.nextLine();
                System.out.println("Wow, " + AfterHS + " sounds like a plan!");
            }
        }else {
            System.out.println("What is your job?");
            String JobEntered =myScanner.nextLine();
            System.out.println(JobEntered + " sounds like a great job!");

        }





    }
}
