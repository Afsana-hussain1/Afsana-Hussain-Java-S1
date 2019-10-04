package com.company;

public class NoticingEvenNumbers {
    public static void main(String[] args) {
        for(int x= 1; x<21; x++ ){
          if(x %2 ==0){
              System.out.println(x + "<---- this number is even!!!");
          }
          else{
              System.out.println(x);
          }
        }
    }
}
