package com.company;
import java.util.Scanner;
public class ArrayFun5Words {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("type in a word");
        String wordOne=myScanner.nextLine();

        System.out.println("type in another word!");
        String wordTwo =myScanner.nextLine();

        System.out.println("Type in a third word!");
        String wordThree =myScanner.nextLine();

        System.out.println("Type in a fourth word");
        String wordFour = myScanner.nextLine();

        System.out.println("type in a word!!");
        String wordFive =myScanner.nextLine();

        String wordArray[]= {wordOne,wordTwo,wordThree,wordFour,wordFive};

        for(int x=0;x<wordArray.length; x++){
            System.out.println(wordArray[x] + ",");
        }
    }

}
