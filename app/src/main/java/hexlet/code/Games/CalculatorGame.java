package hexlet.code.Games;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class CalculatorGame implements Game {
    private static final int ROUNDS = 3;
    private static final String[] OPERATIONS = {"+", "-", "*"};

    private final Cli cli; // Add CLI instance

    public CalculatorGame(Cli cli) {
        this.cli = cli;
    }

    @Override
    public void start(Scanner scanner, String playerName) {
        cli.displayMessage(playerName + ", let's play the Calculator game!");
        System.out.println("What is the result of the expression?");

        for (int i = 0; i < ROUNDS; i++) {
            int num1 = new Random().nextInt(100);
            int num2 = new Random().nextInt(100);
            String operation = OPERATIONS[new Random().nextInt(OPERATIONS.length)];

            int correctAnswer = calculateAnswer(num1, num2, operation);
            System.out.printf("Question: %d %s %d%n", num1, operation, num2);
            System.out.print("Your answer: ");

            try {
                int userAnswer = scanner.nextInt();
                if (userAnswer == correctAnswer) {
                    System.out.println("Correct!");
                } else {
                    System.out.printf("%d - wrong answer! The correct answer was '%d'.%n", userAnswer, correctAnswer);
                    System.out.printf("Let's try again, %s!%n", playerName);
                    return; // End game on wrong answer
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input, please enter a number.");
                scanner.nextLine(); // Clear buffer for next input
                return; // End game if input is invalid
            }
        }

        System.out.printf("Congratulations, %s!%n", playerName);
    }

    private int calculateAnswer(int num1, int num2, String operation) {
        return switch (operation) {
            case "+" -> num1 + num2;
            case "-" -> num1 - num2;
            case "*" -> num1 * num2;
            default -> throw new IllegalArgumentException("Unknown operation: " + operation);
        };
    }
}