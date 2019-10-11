package com.company;

import java.time.Year;
import java.util.List;
import java.util.Scanner;
import java.util.Scanner;
public class App {

    public static void main(String[] args) {

        Inventory inventory = new Inventory();
        System.out.println("\t\t*****Welcome to CarDB!******");
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        String userInput = "";
        boolean timeToClose = false;

        while (!timeToClose) {

            System.out.println("**1 or list: List cars");
            System.out.println("**2 or add: Add a car");
            System.out.println("**3 or remove: Remove a car");
            System.out.println("**4 or search: Search for a car");
            System.out.println("***close the program");
            System.out.println();
            System.out.print("Input here: ");

            while (!timeToClose) {
                userInput = scanner.nextLine();
                switch (userInput) {

                    case "1":
                    case "list":

                        String entries = "";
                        if (inventory.getCarDB().size() == 1) entries = " entry.";
                        else entries = " entries.";

                        System.out.println("Found " + inventory.getCarDB().size() + entries +
                                " *would you like to filter or print all? Default option = print all. (Yes, No)");
                        System.out.println();
                        System.out.print("input here: ");
                        userInput = scanner.nextLine();
                        System.out.println();
                        //Determine if user wants to dig down a big list
                        if (userInput.equals("Yes") || userInput.equals("yes") ||
                                userInput.equals("y") || userInput.equals("Y")) {
                            System.out.println();
                            System.out.println("Make");
                            System.out.println("Model");
                            System.out.println("Year");
                            System.out.println("Below a certain mileage (type: Miles)");
                            System.out.println("Color");
                            System.out.print("Filter by (Type selection): ");
                            userInput = scanner.nextLine();
                            System.out.println();

                        }

                        switch (userInput.toLowerCase()) {
                            case "make":
                                System.out.print("**input Model of  car: ");
                                userInput = scanner.nextLine();
                                System.out.println();
                                List<Car> makeList = inventory.filterByMake(userInput);
                                if (makeList.isEmpty()) {
                                    System.out.println("There are no entries located.");
                                } else inventory.printList(makeList);
                                break;
                            case "model":
                                System.out.print("**Input Make of car: ");
                                userInput = scanner.nextLine();
                                System.out.println();
                                List<Car> modelList = inventory.filterByModel(userInput);
                                if (modelList.isEmpty()) {
                                    System.out.println("There are no entries located");
                                } else inventory.printList(modelList);
                            case "year":
                                System.out.print("Input Year of car: ");
                                int year = 0;
                                while (year < 1886 || year > Year.now().getValue()) {
                                    try {
                                        year = Integer.parseInt(scanner.nextLine());
                                    } catch (NumberFormatException e) {
                                        System.out.println("Input a valid year.");
                                        System.out.print("Input Year: ");
                                    }
                                }
                                List<Car> yearList = inventory.filterByYear(year);
                                if (yearList.isEmpty()) {
                                    System.out.println("There were no entries located.");
                                } else inventory.printList(yearList);
                            case "miles":
                                System.out.print("*Input Maximum Mileage you are searching for: ");
                                int minMileage = -1;
                                while (minMileage <= 0) {
                                    try {
                                        minMileage = Integer.parseInt(scanner.nextLine());
                                    } catch (NumberFormatException e) {
                                        System.out.println("Input  mileage larger than 0.");
                                        System.out.print("Input Year: ");
                                    }
                                }
                                List<Car> mileageList = inventory.filterByMilesLessThanInput(minMileage);
                                if (mileageList.isEmpty()) {
                                    System.out.println("There were no entries located.");
                                } else inventory.printList(mileageList);
                            case "color":
                                System.out.print("Input Color: ");
                                userInput = scanner.nextLine();
                                System.out.println();
                                List<Car> colorList = inventory.filterByColor(userInput);
                                if (colorList.isEmpty()) {
                                    System.out.println("There were no entries located");
                                } else inventory.printList(colorList);


                        }
                        if (userInput.equals("quit") || userInput.equals("exit")) {
                            timeToClose = true;
                            break;

                        } else {
                            inventory.printFullList();
                            System.out.println("redirecting to home!");
                        }
                        break;
                    //
                    case "2":
                    case "add":
                        break;
                    //
                    case "3":
                    case "remove":
                        break;
                    //
                    case "4":
                    case "search":
                        break;
                    //
                    case "quit":
                    case "exit":
                        timeToClose = true;
                        System.out.println("**Thank you for using car DB!!!");
                      break;
            }}
        }
    }
}


