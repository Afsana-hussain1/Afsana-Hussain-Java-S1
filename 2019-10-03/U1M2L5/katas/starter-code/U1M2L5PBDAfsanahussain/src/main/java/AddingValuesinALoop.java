import java.util.Scanner;
public class AddingValuesinALoop {

    public static void main(String[] args) {


        Scanner myScanner = new Scanner(System.in);
        System.out.println("I will add up the numbers you give me");
        System.out.print("number: ");
        int userInput = myScanner.nextInt();
        System.out.print("number:");
        int userInput2 = myScanner.nextInt();

        while (userInput != 0 && userInput2 != 0) {
            int total = userInput + userInput2;

            System.out.println("The total so far is " + total);
            System.out.print("Number: ");
            userInput = myScanner.nextInt();

            System.out.print("Number: ");
            userInput2 = myScanner.nextInt();
            System.out.println("The total so far is " + total);
        }
        int total = 0;
        while (userInput != 0) {
            userInput = myScanner.nextInt();
            total += userInput;
        }
        System.out.println("Total: " + total);
    }

}

