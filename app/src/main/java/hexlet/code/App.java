package hexlet.code;

import hexlet.code.games.Cli;
import hexlet.code.games.EvenGame;
import hexlet.code.games.CalculatorGame;
import hexlet.code.games.GcdGame;
import hexlet.code.games.ProgressionGame;
import hexlet.code.games.PrimeGame;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("Welcome to the Brain Games!");
                System.out.println("Please enter the game number and press Enter.");
                System.out.println("1 - Greet");
                System.out.println("2 - Even");
                System.out.println("3 - Calc");
                System.out.println("4 - GCD");
                System.out.println("5 - Progression");
                System.out.println("6 - Prime");
                System.out.println("0 - Exit");
                System.out.print("Your choice: ");

                if (scanner.hasNextLine()) {
                    int choice = Integer.parseInt(scanner.nextLine());
                    switch (choice) {
                        case 1:
                            Cli.greetUser(scanner);
                            return; // Завершение после приветствия
                        case 2:
                            Engine.runGame(new EvenGame()); // Запуск игры "Even"
                            return; // Завершение после игры
                        case 3:
                            Engine.runGame(new CalculatorGame()); // Запуск игры "Calc"
                            return; // Завершение после игры
                        case 4:
                            Engine.runGame(new GcdGame()); // Запуск игры "GCD"
                            return;
                        case 5:
                            Engine.runGame(new ProgressionGame()); // Запуск игры "Progression"
                            return;
                        case 6:
                            Engine.runGame(new PrimeGame()); // Запуск игры "Prime"
                            return;
                        case 0:
                            System.out.println("Goodbye!");
                            return;
                        default:
                            System.out.println("Invalid choice. Please try again.");
                    }
                }
            }
        }
    }
}
