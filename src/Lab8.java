import java.text.DecimalFormat;     //DecimalFormat is how you make sure there are 3 decimals
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;  //IntStream finds the sum of an int array

public class Lab8 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int bases;
        char anotherBatter;
        DecimalFormat df = new DecimalFormat("0.000");


        do {
            // Ask for number of at bats (only accept numbers 0-4)
            System.out.println("Enter the number of times at bat: ");
            int numAtBats = scan.nextInt();
            if (numAtBats < 0 || numAtBats > 50) {
                throw new RuntimeException("Invalid entry.");
            }
            int[] atBats = new int[numAtBats];

            // Ask for number of bases earned
            System.out.println("0 = out, 1 = single, 2 = double, 3 = triple, 4 = home run");
            for (int i = 0; i < numAtBats; i++) {
                System.out.println("Result for at-bat " + i + ": ");
                bases = scan.nextInt();
                if (bases < 0 || bases > 4) {
                    System.out.println("Invalid entry. Please enter a number 0-4.");
                    i--;
                } else {
                    atBats[i] = bases;
                }
            }
            System.out.println(Arrays.toString(atBats));

            // Display batting average
            int batAvgCalcCounter = 0;                      //declaring to 0 so loop always begins at 0
            for (int i = 0; i < numAtBats; i++) {
                if (atBats[i] != 0) {
                    batAvgCalcCounter++;
                }
            }
            double batAvg = batAvgCalcCounter / (double) numAtBats;  //casting int to double
            System.out.println("Batting Average: " + df.format(batAvg));

            // Display slugging percentage
            int sum = IntStream.of(atBats).sum();
            double sluggingPercentage = sum / (double) numAtBats;
            System.out.println("Slugging Percentage: " + df.format(sluggingPercentage));

            boolean isValidInput = false;
            do {
                //Another batter?
                System.out.println("Would you like to calculate for another batter? (y/n)");
                scan.nextLine();                                    //resets the scanner
                anotherBatter = scan.next().charAt(0);
                if (Character.toLowerCase(anotherBatter) == Character.toLowerCase('y')) {
                    System.out.println("Let's continue!");
                    isValidInput = true;
                } else if (Character.toLowerCase(anotherBatter) == Character.toLowerCase('n')) {
                    System.out.println("Goodbye!");
                    isValidInput = true;
                } else {
                    System.out.println("Sorry, that's not a valid option.");
                }
            } while (!isValidInput);
        } while (Character.toLowerCase(anotherBatter) == Character.toLowerCase('y'));


    }
}
