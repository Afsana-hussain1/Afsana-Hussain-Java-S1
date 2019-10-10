package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ArrayListWhereIsIt {
    public static void main(String[] args) {

        Random random = new Random();
        List<Integer> numbers = new ArrayList<>();

        for(int i= 0; i<50; i++){
            numbers.add(random.nextInt(50) + 1);
        }
        System.out.println("Arraylist:" + numbers);


        System.out.println("Value to find!");
        Scanner myScanner = new Scanner(System.in);
        Integer userInput =myScanner.nextInt();

        if(numbers.contains(userInput)){
            System.out.println( userInput + " is in slot  " + numbers.indexOf(userInput));
        }else{
            System.out.println(userInput + " is not in the Arraylist");
        }



    }

}

