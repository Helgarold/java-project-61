package hexlet.code;

import hexlet.code.games.Cli;
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
    private static final int NUMBER_OF_QUESTIONS = 3; // Новая константа для количества вопросов в игре

    /**
     * Главный метод приложения, который запускает меню игр.
     *
     * @param args аргументы командной строки, которые игнорируются.
     */
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            displayMenu();
            if (scanner.hasNextLine()) {
                String input = scanner.nextLine();
                handleUserInput(input.trim(), scanner);
            }
        }
    }

    /**
     * Отображает меню выбора игр.
     */
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

    /**
     * Обрабатывает выбор пользователя и запускает соответствующую игру.
     *
     * @param input строка, представляющая выбор пользователя.
     * @param scanner объект Scanner для ввода пользователя.
     */
    private static void handleUserInput(String input, Scanner scanner) {
        try {
            int choice = Integer.parseInt(input);
            switch (choice) {
                case GREET_GAME:
                    Cli.greetUser(scanner); // Запуск приветствия
                    break; // Завершение программы после приветствия
                case EVEN_GAME:
                    Engine.runGame(new EvenGame().getWelcomeMessage(),
                            new EvenGame().getGameData(NUMBER_OF_QUESTIONS)); // Запуск игры "Even"
                    break; // Завершение программы после игры
                case CALCULATOR_GAME:
                    Engine.runGame(new CalculatorGame().getWelcomeMessage(),
                            new CalculatorGame().getGameData(NUMBER_OF_QUESTIONS)); // Запуск игры "Calc"
                    break; // Завершение программы после игры
                case GCD_GAME:
                    Engine.runGame(new GcdGame().getWelcomeMessage(),
                            new GcdGame().getGameData(NUMBER_OF_QUESTIONS)); // Запуск игры "GCD"
                    break; // Завершение программы после игры
                case PROGRESSION_GAME:
                    Engine.runGame(new ProgressionGame().getWelcomeMessage(),
                            new ProgressionGame().getGameData(NUMBER_OF_QUESTIONS)); // Запуск игры "Progression"
                    break; // Завершение программы после игры
                case PRIME_GAME:
                    Engine.runGame(new PrimeGame().getWelcomeMessage(),
                            new PrimeGame().getGameData(NUMBER_OF_QUESTIONS)); // Запуск игры "Prime"
                    break; // Завершение программы после игры
                case EXIT_GAME:
                    System.out.println("Goodbye!");
                    return; // Завершение работы программы
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
        }
    }
}
