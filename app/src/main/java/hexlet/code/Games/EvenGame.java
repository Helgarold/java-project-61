package hexlet.code.Games;

import java.util.Scanner;
import java.util.Random;

public class EvenGame implements Game {
    private final Cli cli;
    private final Random random;

    public EvenGame(Cli cli) {
        this.cli = cli;
        this.random = new Random(); // Инициализация Random один раз
    }

    @Override
    public void start(Scanner scanner, String playerName) {
        cli.displayMessage(playerName + ", let's play the Even / Odd game!");
        cli.displayMessage("Rules: Answer 'yes' if the number is even, and 'no' if it is not.");

        for (int round = 0; round < 3; round++) {
            int number = random.nextInt(100) + 1; // Random number from 1 to 100
            cli.displayMessage("Round " + (round + 1) + ": " + number);

            String answer;
            while (true) {
                cli.displayMessage("Is this number even? (yes/no): ");
                answer = scanner.next();

                if (answer.equals("yes") || answer.equals("no")) {
                    break; // Exit loop if input is valid
                } else {
                    cli.displayMessage("Invalid input! Please enter 'yes' or 'no'.");
                }
            }

            String correctAnswer = (number % 2 == 0) ? "yes" : "no";

            if (answer.equals(correctAnswer)) {
                cli.displayMessage("Correct!");
            } else {
                cli.displayMessage("Wrong! The correct answer was: " + correctAnswer);
                cli.displayMessage(String.format("Let's try again, %s!", playerName));
                return; // End game on wrong answer
            }
        }

        cli.displayMessage(String.format("Congratulations, %s!", playerName)); // Congratulate the player after all rounds
    }
}