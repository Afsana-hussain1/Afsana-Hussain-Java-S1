package com.company;
import java.util.Random;
import java.util.ArrayList;

public class LocatingLargestValueInAnArray {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        Random generateRand = new Random();
        int largeNum = 0;
        int slot = 0;

        for (int i = 0; i < 10; i++){
            int randomInt = generateRand.nextInt(50)+1;
            arrayList.add(randomInt);
        }
        System.out.println("ArrayList: " + arrayList);

        for (int i = 0; i < arrayList.size(); i++ ){
            if( largeNum <= arrayList.get(i)){
                largeNum = arrayList.get(i);
                slot = i;
            }

        }
        System.out.println("The Largest Value is " + largeNum + " and it is located in Slot " + slot);



    }
}

