package main.java.week_07;

import java.util.Random;
import java.util.Scanner;

/**
 * Guess the Number
 * <p>
 * You are implementing a simple Guess Number Game. In this game, the computer randomly selects a target number between 1 and 100 (inclusive), and the player tries to guess the correct number. The game provides feedback to the player after each guess, indicating whether the guess is too high, too low, or correct.
 * Write a program to implement the Guess Number Game. Your program should have the following features:
 * 1.	It should display “Welcome to the Guess Number Game!” and “Try to guess the number between 1 and 100”.
 * 2.	The computer generates a random target number between 1 and 100 (inclusive). (This part is optional. If you want to implement it, you can use the Random class to generate random number: https://www.geeksforgeeks.org/generating-random-numbers-in-java/  If you don’t want to implement it, you can use a fixed number, e.g. 45).
 * 3.	The player is allowed to guess the number after displaying “Enter your guess: ”.
 * 4.	After each guess, the program provides feedback to the player:
 * •	If the guess is correct, it displays “Congratulations! You guessed the correct number.”, the game ends, and the player wins.
 * •	If the guess is too high or too low, the player is informed (“Too high! Try again.” or (“Too low! Try again.”), and they can make another guess.
 * 5.	The game continues until the player correctly guesses the number.
 */
public class GuessNumberGame {
    public static void main(String[] args) {
        // Display welcome message
        System.out.println("Welcome to the Guess Number Game!");

        // Generate a random target number between 1 and 100
        int targetNumber = generateRandomNumber();

        // Start the game
        playGuessNumberGame(targetNumber);
    }

    // Method to generate a random number between 1 and 100
    public static int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(100) + 1; // 0  99
//        return (int) (Math.random() * 100) + 1;
    }

    // Method to play the Guess Number Game
    public static void playGuessNumberGame(int targetNumber) {
        Scanner scanner = new Scanner(System.in);
        int guess;

        System.out.println("Try to guess the number between 1 and 100");

        do {
            // Get the player's guess
            System.out.print("Enter your guess: ");
            guess = scanner.nextInt();

            // Provide feedback to the player
            if (guess < targetNumber) {
                System.out.println("Too low! Try again.");
            } else if (guess > targetNumber) {
                System.out.println("Too high! Try again.");
            }
        } while (guess != targetNumber);
        System.out.println("Congratulations! You guessed the correct number.");
        scanner.close();
    }
}


