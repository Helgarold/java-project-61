package hexlet.code.Games;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class CalculatorGame implements Game {
    private static final int ROUNDS = 3;
    private static final String[] OPERATIONS = {"+", "-", "*"};

    private final Cli cli; // Добавляем экземпляр CLI

    public CalculatorGame(Cli cli) {
        this.cli = cli;
    }

    @Override
    public void start(Scanner scanner, String playerName) {
        cli.displayMessage(playerName + ", давай сыграем в игру Калькулятор!");
        System.out.println("Каков результат выражения?");

        for (int i = 0; i < ROUNDS; i++) {
            int num1 = new Random().nextInt(100);
            int num2 = new Random().nextInt(100);
            String operation = OPERATIONS[new Random().nextInt(OPERATIONS.length)];

            int correctAnswer = calculateAnswer(num1, num2, operation);
            System.out.printf("Вопрос: %d %s %d%n", num1, operation, num2);
            System.out.print("Ваш ответ: ");

            try {
                int userAnswer = scanner.nextInt();
                if (userAnswer == correctAnswer) {
                    System.out.println("Правильно!");
                } else {
                    System.out.printf("'%d' - неверный ответ! Правильный ответ был '%d'.%n", userAnswer, correctAnswer);
                    System.out.printf("Попробуйте еще раз, %s!%n", playerName);
                    return; // Завершаем игру при неправильном ответе
                }
            } catch (InputMismatchException e) {
                System.out.println("Некорректный ввод, пожалуйста, введите число.");
                scanner.nextLine(); // Очищаем буфер для следующего ввода
                return; // Завершаем игру, если ввод ненадлежащий
            }
        }

        System.out.printf("Поздравляем, %s!%n", playerName);
    }

    private int calculateAnswer(int num1, int num2, String operation) {
        return switch (operation) {
            case "+" -> num1 + num2;
            case "-" -> num1 - num2;
            case "*" -> num1 * num2;
            default -> throw new IllegalArgumentException("Неизвестная операция: " + operation);
        };
    }
}