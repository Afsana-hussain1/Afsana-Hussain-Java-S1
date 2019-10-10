package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class CopyingArraylists {
    public static void main(String[] args) {
              Random random = new Random();
                ArrayList<Integer> numbers = new ArrayList<Integer>();

             for(int i= 0; i<=100; i++){
               numbers.add(random.nextInt(100) + 1);
          }
              System.out.println("Arraylist:" + numbers);


                System.out.println("Actual ArrayList:"+numbers);
                ArrayList<String> copy = (ArrayList<String>) numbers.clone();
                System.out.println("Cloned ArrayList:"+copy);

            }
        }


