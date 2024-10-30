package hexlet.code;

import hexlet.code.Games.CalculatorGame;
import hexlet.code.Games.EvenGame;
import hexlet.code.Games.Cli;
import hexlet.code.Games.GcdGame;
import hexlet.code.Games.ProgressionGame;
import hexlet.code.Games.PrimeGame;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    private final Scanner scanner;
    private final Cli cli;
    private final GameEngine gameEngine;

    public App(Scanner scanner) {
        this.scanner = scanner;
        this.cli = new Cli(scanner);
        this.gameEngine = new GameEngine();
    }

    public void start() {
        String name = cli.greetUser();
        while (true) {
            cli.displayMenu();
            int choice;
            try {
                choice = cli.getChoice();
            } catch (InputMismatchException e) {
                cli.displayMessage("Invalid input, please enter a number from 0 to 6."); // Изменено
                scanner.nextLine(); // очищаем буфер
                continue;
            }

            switch (choice) {
                case 1:
                    cli.displayMessage("Your choice: 1 - Greet");
                    cli.displayMessage(name + ", welcome to Brain Games!");
                    break;
                case 2:
                    gameEngine.runGame(new EvenGame(cli), name, scanner);
                    break;
                case 3:
                    gameEngine.runGame(new CalculatorGame(cli), name, scanner);
                    break;
                case 4:
                    gameEngine.runGame(new GcdGame(cli), name, scanner); // Запуск игры GCD
                    break;
                case 5:
                    gameEngine.runGame(new ProgressionGame(cli), name, scanner); // Запуск игры Progression
                    break;
                case 6: // Новый выбор для PrimeGame
                    gameEngine.runGame(new PrimeGame(cli), name, scanner); // Исправлено: добавлен cli
                    break;
                case 0:
                    cli.displayMessage("Thank you for playing, " + name + "! Goodbye!");
                    scanner.close();
                    return;
                default:
                    cli.displayMessage("Invalid choice, please select a number from 0 to 6."); // Изменено
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        new App(scanner).start(); // Запускаем приложение
    }
}