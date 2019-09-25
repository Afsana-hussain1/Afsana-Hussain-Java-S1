package com.company;

import java.util.Scanner;

public class CommandLineGram {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String FirstName;
        String LastName;
        String eMail;
        String TwitterHandle;
        String Age;
        String Country;
        String Profession;
        String favOperatingSys;
        String favProgramLan;
        String FavCompScient;
        String KeyBs;
        String hasBuilt;
        String SuperHero;

        System.out.println("What is your First name?");
        FirstName = scan.nextLine();
        System.out.println(FirstName);

        System.out.println("last name?");
        LastName = scan.nextLine();
        System.out.println(LastName);

        System.out.println("What is your Email?");
        eMail = scan.nextLine();
        System.out.println(eMail);

        System.out.println("Twitter username?");
        TwitterHandle = scan.nextLine();
        System.out.println(TwitterHandle);

        System.out.println("Age?");
        Age = scan.nextLine();
        System.out.println(Age);

        System.out.println("what country are you from?");
        Country = scan.nextLine();
        System.out.println(Country);

        System.out.println("What is your Profession?");
        Profession = scan.nextLine();
        System.out.println(Profession);

        System.out.println("what is your favorite OS?");
        favOperatingSys = scan.nextLine();
        System.out.println(favOperatingSys);

        System.out.println("What is your favorite programming language?");
        favProgramLan =scan.nextLine();
        System.out.println(favProgramLan);

        System.out.println("what is your favorite computer scientist?");
        FavCompScient = scan.nextLine();
        System.out.println(FavCompScient);

        System.out.println(" whats your favorite keyboard shortcut");
        KeyBs = scan.nextLine();
        System.out.println(KeyBs);

        System.out.println("have you ever built your own computer?");
        hasBuilt =scan.nextLine();
        System.out.println(hasBuilt);

        System.out.println("if you could be any superhero who would you be?");
        SuperHero =scan.nextLine();
        System.out.println(SuperHero);
    }

}
