package hexlet.code.games;

import java.util.Random;

public class GcdGame {
    private static final Random RANDOM = new Random();
    private static final int MAX_NUMBER = 100; // Максимальное число для генерации
    private static final int MIN_NUMBER = 1;   // Минимальное число для генерации

    /**
     * Возвращает приветственное сообщение для игры.
     *
             * @return строка с приветственным сообщением.
            */
    public String getWelcomeMessage() {
        return "Find the greatest common divisor of given numbers.";
    }

    /**
            * Генерирует вопрос для игры, состоящий из двух случайных чисел.
            *
            * @return строку, представляющую два сгенерированных числа, разделенных пробелом.
     */
    public String getQuestion() {
        int num1 = RANDOM.nextInt(MAX_NUMBER - MIN_NUMBER + 1) + MIN_NUMBER;
        int num2 = RANDOM.nextInt(MAX_NUMBER - MIN_NUMBER + 1) + MIN_NUMBER;
        return num1 + " " + num2; // Возвращает строку с двумя числами
    }

    /**
     * Получает правильный ответ на вопрос, состоящий из двух чисел.
            *
            * @param question строка с вопросом, содержащим два числа.
            * @return строку с правильным ответом, представляющим наибольший общий делитель (НОД) двух чисел.
            */
    public String getCorrectAnswer(String question) {
        String[] parts = question.split(" ");
        int num1 = Integer.parseInt(parts[0]);
        int num2 = Integer.parseInt(parts[1]);

        return String.valueOf(gcd(num1, num2)); // Возвращает НОД
    }

    /**
            * Вычисляет наибольший общий делитель (НОД) двух чисел.
            *
            * @param a первое число.
     * @param b второе число.
     * @return наибольший общий делитель двух чисел.
     */
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
