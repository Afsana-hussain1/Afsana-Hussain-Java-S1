import java.util.Scanner;

public class SafeSquareRoot {

    public static void main(String[] args) {
        System.out.println("SQUARE ROOT!");
        System.out.println("Enter a number");
        Scanner myScanner = new Scanner(System.in);
        int userInput =Integer.parseInt(myScanner.nextLine());

        while(userInput <0){
            System.out.println("Number is too low! cannot be negative please re enter");
            userInput =Integer.parseInt(myScanner.nextLine());
        }

        double squareRoot = Math.sqrt(userInput);
        System.out.println("the square root of " + userInput+  "is " + squareRoot);

    }
}
