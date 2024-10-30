package hexlet.code.Games;

import java.util.Random;
import java.util.Scanner;

public class GcdGame implements Game {
    private static final Random random = new Random();
    private final Cli cli; // Add a field for Cli

    public GcdGame(Cli cli) {
        this.cli = cli; // Save the passed instance
    }

    @Override
    public void start(Scanner scanner, String playerName) {
        System.out.println("Find the greatest common divisor of the given numbers.");

        for (int i = 0; i < 3; i++) {
            int num1 = random.nextInt(100) + 1; // Random number from 1 to 100
            int num2 = random.nextInt(100) + 1;

            System.out.printf("Question: %d %d%n", num1, num2);
            System.out.print("Your answer: ");
            int userAnswer = scanner.nextInt();

            int correctAnswer = findGcd(num1, num2);
            if (userAnswer == correctAnswer) {
                System.out.println("Correct!");
            } else {
                System.out.printf("%d - wrong answer! The correct answer was '%d'.%n", userAnswer, correctAnswer);
                System.out.printf("Let's try again, %s!%n", playerName);
                return;
            }
        }

        System.out.printf("Congratulations, %s!%n", playerName);
    }

    private int findGcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}