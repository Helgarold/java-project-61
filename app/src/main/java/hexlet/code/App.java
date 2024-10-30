package hexlet.code;

import hexlet.code.Games.CalculatorGame;
import hexlet.code.Games.EvenGame;
import hexlet.code.Games.Cli;
import hexlet.code.Games.GcdGame;
import hexlet.code.Games.ProgressionGame;

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
                cli.displayMessage("Некорректный ввод, пожалуйста, введите номер от 1 до 5."); // Изменяем сообщение на 1-5
                scanner.nextLine(); // очищаем буфер
                continue;
            }

            switch (choice) {
                case 1:
                    cli.displayMessage("Ваш выбор: 1 - Greetings");
                    cli.displayMessage(name + ", Добро пожаловать в Brain Games!");
                    break;
                case 2:
                    gameEngine.runGame(new EvenGame(cli), name, scanner);
                    break;
                case 3:
                    gameEngine.runGame(new CalculatorGame(cli), name, scanner);
                    break;
                case 4: // Изменение позиции на уровень выше
                    gameEngine.runGame(new GcdGame(cli), name, scanner); // Запуск игры GCD
                    break;
                case 5: // Изменение позиции на уровень выше
                    gameEngine.runGame(new ProgressionGame(cli), name, scanner); // Запуск игры GCD
                    break;
                case 0:
                    cli.displayMessage("Спасибо за игру, " + name + "! До свидания!");
                    scanner.close();
                    return;
                default:
                    cli.displayMessage("Некорректный выбор, пожалуйста, выберите номер от 1 до 5."); // Изменение на 1-5
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        new App(scanner).start(); // Запускаем приложение
    }
}