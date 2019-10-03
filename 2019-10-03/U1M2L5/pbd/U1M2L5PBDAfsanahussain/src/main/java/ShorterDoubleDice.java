import java.util.Random;

public class ShorterDoubleDice {

    public static void main(String[] args) {

        Random generateRand = new Random();
        System.out.println("HERE COMES THE DICE");
        int diceOne = generateRand.nextInt(6) + 1;
         int diceTwo = generateRand.nextInt(6) + 1;


        while (diceOne != diceTwo) {
        int total = diceOne + diceTwo;
        System.out.println("roll #1" + diceOne);
        System.out.println("roll # 2" + diceTwo);
        System.out.println("the total is " + total + "!");
        diceOne = generateRand.nextInt(6) + 1;
        diceTwo = generateRand.nextInt(6) + 1;


        if (diceOne == diceTwo) {
            total = diceOne + diceTwo;
            System.out.println(" roll # 1" + diceOne);
            System.out.println("roll # 2" + diceTwo);
            System.out.println("the total is" + total + "!");
        }


    }

}
}
