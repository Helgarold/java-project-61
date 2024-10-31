package hexlet.code.games;

import java.util.Random;

public class GcdGame {
    private static final Random RANDOM = new Random();
    private static final int MAX_NUMBER = 100; // Максимальное число для генерации
    private static final int MIN_NUMBER = 1;   // Минимальное число для генерации

    /*<strong>
     * Returns a welcome message for the game.
            * This method can be overridden in subclasses to provide a custom message.
            *
            * @return a welcome message
     */
    public String getWelcomeMessage() {
        return "Find the greatest common divisor of given numbers.";
    }

    /*</strong>
            * Generates a question for the game by returning two random numbers.
     * The numbers are in the range from MIN_NUMBER to MAX_NUMBER.
            *
            * @return a string representing the question in the format <num1> <num2>
     */
    public String getQuestion() {
        int num1 = RANDOM.nextInt(MAX_NUMBER - MIN_NUMBER + 1) + MIN_NUMBER; // Генерация числа от MIN_NUMBER до MAX_NUMBER
        int num2 = RANDOM.nextInt(MAX_NUMBER - MIN_NUMBER + 1) + MIN_NUMBER; // Генерация числа от MIN_NUMBER до MAX_NUMBER
        return num1 + " " + num2; // Возвращает строку с двумя числами
    }

    /*<strong>
     * Calculates the correct answer for the given question by finding the greatest common divisor (GCD)
     * of the two numbers provided in the question.
            *
            * @param question a string containing two space-separated numbers
     * @return a string representation of the GCD of the two numbers
     */
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