import java.util.Scanner;

public class RightTriangleChecker {

    public static void main( String[] args )

        { Scanner myScanner = new Scanner(System.in);
          int triangleSideOne, triangleSideTwo, triangelSideThree;

            double rightTriangle;

            System.out.println( "enter three integers:" );
            System.out.print( "side 1: " );
            triangleSideOne = myScanner.nextInt();

            do
            { System.out.print( "side 2: " );
              triangleSideTwo = myScanner.nextInt();

              while ( triangleSideOne > triangleSideTwo )
                  System.out.println( triangleSideTwo + " is smaller than " + triangleSideOne + ". Try again." );

            }
            while ( triangleSideOne > triangleSideTwo);

            do

            { System.out.print( "Side 3: " );
              triangelSideThree = myScanner.nextInt();
              if ( triangleSideTwo > triangelSideThree )
                  System.out.println( triangelSideThree+ " is smaller than " + triangleSideTwo + ". Try again." );

            }
            while ( triangleSideTwo > triangelSideThree );
            System.out.println( "Your three sides are " + triangleSideOne + " " + triangleSideTwo + " " + triangelSideThree );
            rightTriangle = Math.sqrt( (triangleSideOne * triangleSideOne ) + (triangleSideTwo * triangleSideTwo) );



            if (rightTriangle == triangelSideThree )
                System.out.println( "These sides *do* make a right triangle. Yippy-skippy!" );

            else
                System.out.println( "NO! These sides do not make a right triangle!" );

        }

    }

