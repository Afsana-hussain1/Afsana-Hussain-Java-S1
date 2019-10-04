package com.company;

public class ArrayReverseIt {
    public static void main(String[] args) {
        int array1[] ={1,2,3,4,5,};
        int numOne = array1[0];
        int numTwo = array1[1];
        int numThree = array1[2];
        int numFour = array1[3];
        int numFive= array1[4];
        int reverseArray[]= {numFive,numFour,numThree,numTwo,numOne};
        for(int x=0;x<array1.length;x++){
            System.out.println(array1[x] + ",");
        }

        System.out.println("\n");
        System.out.println("reverse array \n");
        for(int x=0;x<reverseArray.length;x++){
            System.out.println(reverseArray[x] + ",");
        }
    }
}
