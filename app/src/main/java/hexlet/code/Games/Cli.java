package hexlet.code.Games;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Cli {
    private final Scanner scanner;

    public Cli(Scanner scanner) {
        this.scanner = scanner;
    }

    public String greetUser() {
        System.out.print("Введите ваше имя: ");
        return scanner.nextLine();
    }

    public void displayMenu() {
        System.out.println("1 - Greetings");
        System.out.println("2 - Even game");
        System.out.println("3 - Calculator game");
        System.out.println("4 - Exit");
    }

    public int getChoice() {
        while (true) {
            System.out.print("Выберите действие: ");
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Некорректный ввод, пожалуйста, введите номер действия.");
                scanner.nextLine(); // очищаем буфер
            }
        }
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }
}