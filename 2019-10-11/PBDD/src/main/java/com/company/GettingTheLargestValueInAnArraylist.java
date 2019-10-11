package com.company;
import java.util.ArrayList;
import java.util.Random;

public class GettingTheLargestValueInAnArraylist {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        Random generateRand = new Random();
        int largeNum = 0;

        for (int i = 0; i < 10; i++){
            int randomInt = generateRand.nextInt(50)+1;
            arrayList.add(randomInt);
        }
        System.out.println("ArrayList: " + arrayList);

        for (int i = 0; i < arrayList.size(); i++ ){
            if( largeNum <= arrayList.get(i)){
                largeNum = arrayList.get(i);

            }
        }
        System.out.println("The Largest Value is " + largeNum);

    }
}


