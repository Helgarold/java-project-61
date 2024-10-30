package hexlet.code.Games;

import java.util.Scanner;
import java.util.Random;

public class PrimeGame implements Game {
    private final Cli cli;
    private final Random random;

    public PrimeGame(Cli cli) {
        this.cli = cli;
        this.random = new Random();
    }

    @Override
    public void start(Scanner scanner, String playerName) {
        cli.displayMessage("Welcome to the Brain Games!");
        cli.displayMessage("May I have your name? " + playerName);
        cli.displayMessage("Answer 'yes' if given number is prime. Otherwise answer 'no'.");

        for (int round = 0; round < 3; round++) {
            int number = random.nextInt(100) + 1; // Random number from 1 to 100
            cli.displayMessage("Question: " + number);

            String answer;
            while (true) {
                cli.displayMessage("Your answer: "); // Prompt for answer
                answer = scanner.next();

                if (answer.equals("yes") || answer.equals("no")) {
                    break; // Exit loop if input is valid
                } else {
                    cli.displayMessage("Invalid input! Please enter 'yes' or 'no'.");
                }
            }

            String correctAnswer = isPrime(number) ? "yes" : "no";

            if (answer.equals(correctAnswer)) {
                cli.displayMessage("Correct!");
            } else {
                cli.displayMessage("Wrong! The correct answer was: " + correctAnswer);
                cli.displayMessage("Let's try again, " + playerName + "!");
                return; // End game on wrong answer
            }
        }

        cli.displayMessage("Congratulations, " + playerName + "! You answered correctly to all questions!");
    }

    private boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}