import java.util.Scanner;

/**
 * Created by Carlos Shows on 2/10/17.
 */
public class Lab8A {
    public static int getAtBats(Scanner sc, String prompt) {
        int n = -1;
        //String prompt = "Please enter an integer: ";
        System.out.print(prompt);

        do {//as long as there's NOT an int
            //prompt the user to enter again
            try {
                while (!sc.hasNextInt()) {
                    sc.nextLine();
                    System.out.println("I'm sorry, that's not an int. ");
                    System.out.print(prompt);

                }

                // take valid int as input
                n = sc.nextInt();
                while (n > 4 || n < 0) {
                    System.out.println("I'm sorry that's an invalid amount");
                    System.out.println(prompt);
                    n = sc.nextInt();
                }
            } catch (Exception e) {

            }
        } while (n == -1);

        //clear out the enter here
        sc.nextLine();

        return n;
    }


    public static void main(String[] args) {
        //Resources
        Scanner scan = new Scanner(System.in);


        int atBats = 0;             // variable for num of at bats that user inputs

        String answer = "";
        int numbBatters;


        System.out.println("Welcome! I'm Attie Baverage! I can help you find your players Batting Average. ");


        System.out.println("Enter number of batters: ");
        numbBatters = scan.nextInt();

        System.out.print("Enter number at bats: ");
        atBats = scan.nextInt();
        int[][] batStats = new int[numbBatters][atBats];
        for (int row = 0; row < batStats.length; row++) {

            System.out.println("Enter Batter # " + (row +1));


            for (int col = 0; col < batStats[row].length; col++) {
                System.out.println("0 = Out, 1 = single, 2 = double, 3 = triple, 4 = home run");
                batStats[row][col] = scan.nextInt();
            }
        }

        //iterate through batters(rows)
        for (int row = 0; row < batStats.length; row++) {
            int bases = 0;
            int hits = 0;
            //iterate through this batters at-bats(columns)
            for (int col = 0; col < batStats[row].length; col++) {

                //add number of bases to total number
                bases += batStats[row][col];
                //if its a hit, increment the count of hits
                if(batStats[row][col] > 0){
                    hits++;
                }
            }
            //output the batting average for this batter
            double batAvg = (double)hits / batStats[row].length;
            System.out.printf("For batter %d, Batting Average: %.3f", (row + 1), batAvg);

            //output the slugging percentage "        "
            double slugPerc = (double)bases / batStats[row].length;
            System.out.printf("\tSlugging Percentage: %.3f\n", slugPerc);
        }





//        //user input determines length of array
//        int[] numbBats = new int[atBats];
//
//        //instruct user on what to input
//
//
//        //*request the number of bases
//        // * For each at bat, ask the  user for the number of bases earned by the batter
//        //traverse array and take input that assigns a number of bases earned per at-bat
//
//        for (int i = 0; i < numbBats.length; i++) {
//            //System.out.print("Enter the number of bases earned at the at-bat #" + (i + 1) + ": ");
//            /* use array to store at bats results for each player */
//            numbBats[i] = getAtBats(scan, "Enter the number of bases earned at the at-bat #" + (i + 1) + ": ");
//
//        }
//
//        //sum amount of bases in array indices
//        // counts number of hits
//        for (int i : numbBats) {
//            if (i > 0) {
//                numbHits++;
//            }
//            baseSum += i;
//        }
//
//            /* Calculate the batting average and slugging percentage for one or more
//                baseball/softball players */
//        System.out.println("number of at-bats is: " + atBats);
//        System.out.println("sum of bases is: " + baseSum);
//        System.out.println("sum of hits is: " + numbHits);
//
//            /*After all the at-bats are entered, display the batting average and slugging
//            percentage of the batter */
//        System.out.printf("Batting average is: %.3f", (double) numbHits / atBats);
//        System.out.println("");
//        //printf may solve 3 decimal task %f
//        System.out.printf("Slugging percentage is: %.3f", (double) baseSum / atBats);
//        System.out.println("");

        System.out.println("Another batter? Y/N?");
        answer = scan.next();

        //}while(answer.equalsIgnoreCase("y"));

        System.out.println("Alright, until next game!");

        scan.close();
    }


}