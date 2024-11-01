package hexlet.code.games;

import java.util.Random;

public class GcdGame {
    private static final Random RANDOM = new Random();
    private static final int MAX_NUMBER = 100; // Максимальное число для генерации
    private static final int MIN_NUMBER = 1;   // Минимальное число для генерации

    /**
     *
     * @return
     */
    public String getWelcomeMessage() {
        return "Find the greatest common divisor of given numbers.";
    }

    /**
     *
     * @return
     */
    public String getQuestion() {
        int num1 = RANDOM.nextInt(MAX_NUMBER - MIN_NUMBER + 1) + MIN_NUMBER;
        // Генерация числа от MIN_NUMBER до MAX_NUMBER
        int num2 = RANDOM.nextInt(MAX_NUMBER - MIN_NUMBER + 1) + MIN_NUMBER;
        // Генерация числа от MIN_NUMBER до MAX_NUMBER
        return num1 + " " + num2; // Возвращает строку с двумя числами
    }

    /**
     *
     * @param question
     * @return
     */
    public String getCorrectAnswer(String question) {
        String[] parts = question.split(" ");
        int num1 = Integer.parseInt(parts[0]);
        int num2 = Integer.parseInt(parts[1]);

        return String.valueOf(gcd(num1, num2)); // Возвращает НОД
    }

    /**
     *
     * @param a
     * @param b
     * @return
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
