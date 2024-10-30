package hexlet.code.Games;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Cli {
    private final Scanner scanner;

    public Cli(Scanner scanner) {
        this.scanner = scanner;
    }

    public String greetUser() {
        System.out.print("Please enter your name: ");
        String name = scanner.nextLine();
        // Удаляем возможный остаток в буфере
        return name;
    }

    public void displayMenu() {
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("3 - Calculator");
        System.out.println("4 - GCD");
        System.out.println("5 - Progression");
        System.out.println("6 - Prime");
        System.out.println("0 - Exit");
    }

    public int getChoice() {
        while (true) {
            System.out.print("Your choice: ");
            try {
                int choice = scanner.nextInt();
                if (choice >= 0 && choice <= 6) {
                    return choice; // Позволяем 0 для выхода
                } else {
                    System.out.println("Invalid input, please select a number from 0 to 6.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input, please enter a number.");
                scanner.nextLine(); // очищаем буфер
            }
        }
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }
}