package hexlet.code;

import hexlet.code.games.EvenGame;
import hexlet.code.games.CalculatorGame;
import hexlet.code.games.GcdGame;
import hexlet.code.games.ProgressionGame;
import hexlet.code.games.PrimeGame;

import java.util.Scanner;

public class App {
    private static final int GREET_GAME = 1;
    private static final int EVEN_GAME = 2;
    private static final int CALCULATOR_GAME = 3;
    private static final int GCD_GAME = 4;
    private static final int PROGRESSION_GAME = 5;
    private static final int PRIME_GAME = 6;
    private static final int EXIT_GAME = 0;

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            displayMenu();
            if (scanner.hasNextLine()) {
                String input = scanner.nextLine();
                handleUserInput(input.trim(), scanner);
            }
        }
    }

    private static void displayMenu() {
        System.out.println("Welcome to the Brain Games!");
        System.out.println("Please enter the game number and press Enter.");
        System.out.println(GREET_GAME + " - Greet");
        System.out.println(EVEN_GAME + " - Even");
        System.out.println(CALCULATOR_GAME + " - Calc");
        System.out.println(GCD_GAME + " - GCD");
        System.out.println(PROGRESSION_GAME + " - Progression");
        System.out.println(PRIME_GAME + " - Prime");
        System.out.println(EXIT_GAME + " - Exit");
        System.out.print("Your choice: ");
    }

    private static void handleUserInput(String input, Scanner scanner) {
        try {
            int choice = Integer.parseInt(input);
            switch (choice) {
                case GREET_GAME:
                    Cli.greetUser(scanner);
                    break;
                case EVEN_GAME:
                    EvenGame.startGame();
                    break;
                case CALCULATOR_GAME:
                    CalculatorGame.startGame();
                    break;
                case GCD_GAME:
                    GcdGame.startGame();
                    break;
                case PROGRESSION_GAME:
                    ProgressionGame.startGame();
                    break;
                case PRIME_GAME:
                    PrimeGame.startGame();
                    break;
                case EXIT_GAME:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
        }
    }
}
