package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BasicArrayLists3 {
    public static void main(String[] args) {
        Random random = new Random();
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i <= 1000; i++) {

            numbers.add(random.nextInt(100) + 1);


        }   System.out.println("Arraylist:" + numbers);



    }
}







