package hexlet.code.Games;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class ProgressionGame implements Game {
    private static final int MAX_LENGTH = 10;
    private static final int MIN_LENGTH = 5;
    private static final Random random = new Random();

    public ProgressionGame(Cli cli) {
    }

    private Object[] generateProgression() {
        int length = random.nextInt(MAX_LENGTH - MIN_LENGTH + 1) + MIN_LENGTH;
        int start = random.nextInt(10);
        int step = random.nextInt(5) + 1;
        int hiddenIndex = random.nextInt(length);

        int[] progression = new int[length];
        for (int j = 0; j < length; j++) {
            progression[j] = start + j * step;
        }

        // Remember the hidden value
        int hiddenValue = progression[hiddenIndex];
        progression[hiddenIndex] = -1; // Replace the hidden value with -1 in the progression

        return new Object[]{progression, hiddenIndex, hiddenValue}; // Return the progression array, the index of the hidden value and the value itself
    }

    @Override
    public void start(Scanner scanner, String playerName) {
        System.out.println("Which number is missing in the progression?");
        int rounds = 3; // Number of questions

        for (int i = 0; i < rounds; i++) {
            // Generate a progression and get the hidden value
            Object[] progressionData = generateProgression();
            int[] progression = (int[]) progressionData[0];
            int hiddenIndex = (int) progressionData[1];
            int hiddenValue = (int) progressionData[2];

            // Output the question
            for (int j = 0; j < progression.length; j++) {
                if (j == hiddenIndex) {
                    System.out.print(".. ");
                } else {
                    System.out.print(progression[j] + " ");
                }
            }
            System.out.println();

            // Get the player's answer
            System.out.print("Your answer: ");
            int playerAnswer;
            try {
                playerAnswer = scanner.nextInt();
                scanner.nextLine(); // Clear the buffer
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number.");
                scanner.nextLine(); // Clear the buffer
                i--; // Repeat the same round
                continue;
            }

            // Check the answer
            if (playerAnswer == hiddenValue) {
                System.out.println("Correct!");
            } else {
                System.out.printf("%d - wrong answer! The correct answer was %d.%n", playerAnswer, hiddenValue);
                System.out.printf("Let's try again, %s!%n", playerName);
                return; // End the game
            }
        }

        System.out.printf("Congratulations, %s!%n", playerName);
    }
}
