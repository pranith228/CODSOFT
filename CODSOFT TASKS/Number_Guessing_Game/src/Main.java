// Import necessary classes for input handling and random number generation
import java.util.Random;
import java.util.Scanner;

// Define the main class for the Number Guessing Game
public class Main {
    // Main method where the program execution starts
    public static void main(String[] args) {
        // Create Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Create Random object for generating random numbers
        Random random = new Random();

        // Set initial game parameters
        int lowerBound = 1;         // Lower bound for the generated number
        int upperBound = 100;       // Upper bound for the generated number
        int maxAttempts;        // Updated maximum number of attempts allowed per round
        int rounds = 0;             // Variable to keep track of the number of rounds played
        int score = 0;              // Variable to keep track of the player's total score

        // Display welcome message
        System.out.println("Helloo, Welcome to the Number Guessing Game!");
        System.out.println("Let's Start the Game....");

        // Start the game loop
        do {
            // Ask the user for difficulty level
            System.out.print("Choose difficulty level (easy/medium/hard): ");
            String difficulty = scanner.next().toLowerCase();

            // Set difficulty-specific parameters
            switch (difficulty) {
                case "easy" -> maxAttempts = 8;
                case "medium" -> maxAttempts = 6;
                case "hard" -> maxAttempts = 4;
                default -> {
                    System.out.println("Invalid difficulty level. Setting to medium.");
                    maxAttempts = 6;
                }
            }

            // Generate a random number within the specified range
            int generatedNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            int attempts = 0;           // Variable to count the number of attempts in each round
            boolean guessedCorrectly = false;  // Flag to check if the user guessed the correct number

            // Display round information
            System.out.println("\nRound " + (rounds + 1) + ": Guess the number between " + lowerBound + " and " + upperBound);
            System.out.println("Difficulty: " + difficulty);

            // Start the loop for user attempts
            while (attempts < maxAttempts && !guessedCorrectly) {
                int remainingAttempts = maxAttempts - attempts;
                System.out.print("Enter your guess (You have " + remainingAttempts + " attempts left): ");

                if (scanner.hasNextInt()) {
                    int userGuess = scanner.nextInt();    // Get user input for the guess

                    if (userGuess >= lowerBound && userGuess <= upperBound) {
                        attempts++;                           // Increment the attempt count

                        // Check if the guess is correct, too low, or too high
                        if (userGuess == generatedNumber) {
                            System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                            guessedCorrectly = true;
                            score += maxAttempts - attempts + 1;  // Update the score based on the number of attempts
                        } else if (userGuess < generatedNumber) {
                            System.out.println("Too low. Try again.");
                        } else {
                            System.out.println("Too high. Try again.");
                        }
                    } else {
                        System.out.println("Sorry, only numbers between 1 and 100 are allowed.");
                        scanner.nextLine(); // Consume the invalid input
                    }
                } else {
                    System.out.println("Sorry, only numbers between 1 and 100 are allowed.");
                    scanner.nextLine(); // Consume the invalid input
                }
            }

            // Display the correct number if the user couldn't guess it
            if (!guessedCorrectly) {
                System.out.println("Sorry! The correct number was: " + generatedNumber);
            }

            rounds++;   // Increment the round count

            // Ask the user if they want to play again
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = scanner.next().toLowerCase();
            if (!playAgain.equals("yes")) {
                break;  // Exit the game loop if the user doesn't want to play again
            }

        } while (true);  // Infinite loop for continuous gameplay

        // Display game over message and the total score
        System.out.println("\nGame over! Your total score is: " + score);
        scanner.close();  // Close the scanner to prevent resource leaks
    }
}
