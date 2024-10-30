package hexlet.code.Games;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class ProgressionGame implements Game {
    private static final int MAX_LENGTH = 10;
    private static final int MIN_LENGTH = 5;
    private static final Random random = new Random();

    public ProgressionGame(Cli cli) {
    }

    private Object[] generateProgression() {
        int length = random.nextInt(MAX_LENGTH - MIN_LENGTH + 1) + MIN_LENGTH;
        int start = random.nextInt(10);
        int step = random.nextInt(5) + 1;
        int hiddenIndex = random.nextInt(length);

        int[] progression = new int[length];
        for (int j = 0; j < length; j++) {
            progression[j] = start + j * step;
        }

        // Запоминаем скрытое значение
        int hiddenValue = progression[hiddenIndex];
        progression[hiddenIndex] = -1; // Заменяем скрытое значение на -1 в прогрессии

        return new Object[]{progression, hiddenIndex, hiddenValue}; // Возвращаем массив прогрессии, индекс скрытого значения и само значение
    }

    @Override
    public void start(Scanner scanner, String playerName) {
        System.out.println("Какое число пропущено в прогрессии?");
        int rounds = 3; // Количество вопросов

        for (int i = 0; i < rounds; i++) {
            // Генерация прогрессии и получение скрытого значения
            Object[] progressionData = generateProgression();
            int[] progression = (int[]) progressionData[0];
            int hiddenIndex = (int) progressionData[1];
            int hiddenValue = (int) progressionData[2];

            // Вывод вопроса
            for (int j = 0; j < progression.length; j++) {
                if (j == hiddenIndex) {
                    System.out.print(".. ");
                } else {
                    System.out.print(progression[j] + " ");
                }
            }
            System.out.println();

            // Получение ответа игрока
            System.out.print("Ваш ответ: ");
            int playerAnswer;
            try {
                playerAnswer = scanner.nextInt();
                scanner.nextLine(); // Очищаем буфер
            } catch (InputMismatchException e) {
                System.out.println("Пожалуйста введите корректное число.");
                scanner.nextLine(); // Очищаем буфер
                i--; // Повторяем тот же раунд
                continue;
            }

            // Проверка ответа
            if (playerAnswer == hiddenValue) {
                System.out.println("Верно!");
            } else {
                System.out.printf("%d - неверный ответ! Правильный ответ был %d.%n", playerAnswer, hiddenValue);
                System.out.printf("Давай попробуем снова, %s!%n", playerName);
                return; // Завершение игры
            }
        }
        System.out.printf("Поздравляю, %s!%n", playerName);
    }
}