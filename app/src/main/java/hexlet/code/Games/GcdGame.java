package hexlet.code.Games;

import java.util.Random;
import java.util.Scanner;

public class GcdGame implements Game {
    private static final Random random = new Random();
    private final Cli cli; // Добавьте поле для Cli

    public GcdGame(Cli cli) {
        this.cli = cli; // Сохраняем переданный экземпляр
    }

    @Override
    public void start(Scanner scanner, String playerName) {
        System.out.println("Найдите наибольший общий делитель данных чисел.");

        for (int i = 0; i < 3; i++) {
            int num1 = random.nextInt(100) + 1; // Случайное число от 1 до 100
            int num2 = random.nextInt(100) + 1;

            System.out.printf("Вопрос: %d %d%n", num1, num2);
            System.out.print("Ваш ответ: ");
            int userAnswer = scanner.nextInt();

            int correctAnswer = findGcd(num1, num2);
            if (userAnswer == correctAnswer) {
                System.out.println("Верно!");
            } else {
                System.out.printf("'%d' - неверный ответ! Правильный ответ был '%d'.%n", userAnswer, correctAnswer);
                System.out.printf("Попробуйте еще раз, %s!%n", playerName);
                return;
            }
        }

        System.out.printf("Поздравляем, %s!%n", playerName);
    }

    private int findGcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}