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
        String name = scanner.nextLine();
        // Удаляем возможный остаток в буфере
        return name;
    }

    public void displayMenu() {
        System.out.println("1 - Greetings");
        System.out.println("2 - Even game");
        System.out.println("3 - Calculator game");
        System.out.println("4 - GCD");
        System.out.println("5 - Exit");
    }

    public int getChoice() {
        while (true) {
            System.out.print("Выберите действие: ");
            try {
                int choice = scanner.nextInt();
                if (choice >= 1 && choice <= 5) {
                    return choice;
                } else {
                    System.out.println("Некорректный ввод, выберите номер от 1 до 5.");
                }
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
