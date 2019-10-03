import java.util.Scanner;

public class ThreeCardMonte {

    public static void main(String[] args) {
        System.out.println( "you plop up to fast eddies card table and plop down your cash.");
        System.out.println("he glances at you out of the corner of his eyes and starts shuffling");
        System.out.println("He lays dow three cards");

        System.out.println("Which one is the Ace?");
        Scanner myScanner = new Scanner(System.in);
        int userGuess = Integer.parseInt(myScanner.nextLine());
        int ace =2;

        if (ace == userGuess) {
            System.out.println("you nailed it! Fast Eddie reluctantly hands over your winnings scowling.");
        } else {
            System.out.println("Ha! fast Eddie wins again The ace was card number " + ace + ".");
        }

        if (ace == 1) {
            System.out.println("AA  ##  ##");
            System.out.println("AA  ##  ##");
        } else if (ace == 2) {
            System.out.println("##  AA  ##");
            System.out.println("##  AA  ##");
        } else if (ace == 3) {
            System.out.println("##  ##  AA");
            System.out.println("##  ##  AA");
        }
        System.out.println("1   2   3");
    }
}
