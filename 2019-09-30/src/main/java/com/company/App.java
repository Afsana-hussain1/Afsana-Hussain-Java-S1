package com.company;

public class App {


    public static int total(int[] array) {

        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            sum = sum + array[i];
        }

        return sum;
    }

    public static int totalOdd(int[] array) {

        int oddNum = 0;

        for (int i = 0; i < array.length; i++) {
            if (i % 2 == 1) {
                oddNum = array[i] + oddNum;
                System.out.println(oddNum);
            }
        }
        return oddNum;
    }

    public static int totalEven(int[] array) {

        int eveNum = 0;

        for (int i = 0; i < array.length; i++) {
            if (i % 2 == 0) {
                eveNum = eveNum + array[i];
            }
        }

        return eveNum;
    }

    public static int secondLargestNumber(int[] array) {

        int firstLargenum = -2147483648;
        int largestNumTwo = -2147483648;

        for (int i = 0; i < array.length; i++) {
            if (array[i] > firstLargenum) {
                firstLargenum = array[i];
            }
        }

        for (int x = 0; x < array.length; x++)
            if (array[x] > largestNumTwo && array[x] < firstLargenum) {
                largestNumTwo = array[x];
            }

        return largestNumTwo;
    }

    public static String[] swapFirstAndLast(String[] array ) {
        String finalElement = array[array.length - 1];
        array[array.length - 1] = array[0];
        array[0] = finalElement;

        return array;
    }


    public static int[] reverse(int[] array) {

        int[] x =new int[array.length];
        int c = array.length - 1;

        for(int i= 0; i < array.length; i++) {
            x[c] = array[i];
            c = c - 1;
        }
        return x;
    }

    public static String concatenateString(String[] array) {
        String combineString = "";

          for ( int i = 0;i<array.length;i++) {
              combineString = combineString + array[i];
          }
          return combineString;
    }

     public static int[] everyThird(int[] arrays) {

        int[] threeArray = new int[arrays.length / 3];
        if(arrays.length < 3) return null;

        int x = 0;
        for(int i = 0; i < arrays.length; i++){
            if ((i + 1) % 3 == 0 ){
                threeArray[x] = arrays[i] ;
                x++;
            }
        }
        return threeArray;
     }

     public static int[] lessThanFive(int[] arrays) {

        int x = 0;
        for (int i = 0; i < arrays.length; i++) {
            if(arrays[i] < 5 ){
                x++;
            }
        }

        if(x == 0) return null;

         int[] fiveArray = new int[x];
         x = 0;

         for(int i = 0; i < arrays.length;i++){
             if (arrays[i] < 5) {
                 fiveArray[x] = arrays[i];
                 x++;
             }
         }
         return fiveArray;
     }
}

