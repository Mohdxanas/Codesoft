import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int maxAttempts = 7;
        int score = 0;
        int roundsWon = 0;
        String playAgain;

        System.out.println(" Welcome to the Number Guessing Game!");

        do {
            int targetNumber = random.nextInt(100) + 1;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("\n New Round Started!");
            System.out.println("Guess a number between 1 and 100. You have " + maxAttempts + " attempts.");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();
                attempts++;

                if (guess < targetNumber) {
                    System.out.println(" Too low!");
                } else if (guess > targetNumber) {
                    System.out.println(" Too high!");
                } else {
                    System.out.println(" Correct! You guessed it in " + attempts + " attempts.");
                    score += (maxAttempts - attempts + 1) * 10; // More points for fewer attempts
                    roundsWon++;
                    guessedCorrectly = true;
                    break;
                }
            }

            if (!guessedCorrectly) {
                System.out.println(" You've used all attempts. The correct number was: " + targetNumber);
            }

            System.out.print("\nDo you want to play another round? (yes/no): ");
            playAgain = scanner.next().toLowerCase();

        } while (playAgain.equals("yes"));

        // Final Score Summary
        System.out.println("\n🏁 Game Over!");
        System.out.println("Rounds Won: " + roundsWon);
        System.out.println("Total Score: " + score);

        scanner.close();
    }
}