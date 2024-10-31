package hexlet.code.games;

import java.util.Random;

public class GcdGame {
    private static final Random RANDOM = new Random();

    public String getWelcomeMessage() {
        return "Find the greatest common divisor of given numbers.";
    }

    public String getQuestion() {
        int num1 = RANDOM.nextInt(100) + 1; // Генерация числа от 1 до 100
        int num2 = RANDOM.nextInt(100) + 1; // Генерация числа от 1 до 100
        return num1 + " " + num2; // Возвращает строку с двумя числами
    }

    public String getCorrectAnswer(String question) {
        String[] parts = question.split(" ");
        int num1 = Integer.parseInt(parts[0]);
        int num2 = Integer.parseInt(parts[1]);

        return String.valueOf(gcd(num1, num2)); // Возвращает НОД
    }

    // Метод для вычисления НОД
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}