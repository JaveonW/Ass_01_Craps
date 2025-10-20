import java.util.Random;
import java.util.Scanner;

public class Ass_01_Craps {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random rnd = new Random();
        boolean playAgain = true;

        System.out.println("Welcome to the Craps Game!");

        while (playAgain) {
            int die1 = rnd.nextInt(6) + 1;
            int die2 = rnd.nextInt(6) + 1;
            int sum = die1 + die2;

            System.out.println("\nYou rolled: " + die1 + " + " + die2 + " = " + sum);

            if (sum == 2 || sum == 3 || sum == 12) {
                System.out.println("Craps! You lose.");
            } else if (sum == 7 || sum == 11) {
                System.out.println("Natural! You win.");
            } else {
                // Case iii - try to make the point
                int point = sum;
                System.out.println("Point is now: " + point);
                boolean rolling = true;

                while (rolling) {
                    die1 = rnd.nextInt(6) + 1;
                    die2 = rnd.nextInt(6) + 1;
                    sum = die1 + die2;
                    System.out.println("Rolling for point... You rolled: " + die1 + " + " + die2 + " = " + sum);

                    if (sum == 7) {
                        System.out.println("You rolled a 7. You lose.");
                        rolling = false;
                    } else if (sum == point) {
                        System.out.println("You made your point! You win.");
                        rolling = false;
                    } else {
                        System.out.println("Still trying for point...");
                    }
                }
            }

            System.out.print("Would you like to play again? (y/n): ");
            String response = input.nextLine().trim().toLowerCase();
            playAgain = response.equals("y");
        }

        System.out.println("Thanks for playing!");
        input.close();
    }
}
