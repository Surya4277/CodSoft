
import java.util.Random;
import java.util.Scanner;
public class NumberGuessingGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int min = 1;
        int max = 100;
        int maxAttempts = 7;
        int rounds = 0;
        int score = 0;
        boolean playAgain = true;

        System.out.println("Welcome to the Number Guessing Game!");

        // Main game loop for multiple rounds
        while (playAgain) {
            rounds++;
            int generatedNumber = random.nextInt(max - min + 1) + min;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("\nRound " + rounds + ": Try to guess the number between " + min + " and " + max);
            System.out.println("You have " + maxAttempts + " attempts.");

            // Loop for guessing attempts
            while (attempts < maxAttempts && !guessedCorrectly) {
                attempts++;
                System.out.print("Attempt " + attempts + ": Enter your guess: ");
                int guess = scanner.nextInt();

                if (guess < generatedNumber) {
                    System.out.println("Too low!");
                } else if (guess > generatedNumber) {
                    System.out.println("Too high!");
                } else {
                    System.out.println("Congratulations! You've guessed the correct number.");
                    guessedCorrectly = true;
                    score++;
                }
            }

            // If the user runs out of attempts
            if (!guessedCorrectly) {
                System.out.println("Sorry! You've used all " + maxAttempts + " attempts. The correct number was " + generatedNumber + ".");
            }

            // Ask if the user wants to play again
            System.out.print("Do you want to play another round? (yes/no): ");
            String response = scanner.next().toLowerCase();
            if (!response.equals("yes")) {
                playAgain = false;
            }
        }

        // Display final score and rounds
        System.out.println("\nGame over! You played " + rounds + " rounds and won " + score + " times.");
        scanner.close();
	}

}
