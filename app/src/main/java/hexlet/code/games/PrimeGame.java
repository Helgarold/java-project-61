package hexlet.code.games;

import java.util.Random;

public class PrimeGame {
    private static final Random RANDOM = new Random();
    private static final int MAX_NUMBER = 100; // Константа для верхнего предела

    /**
     *
     * @return
     */
    public String getWelcomeMessage() {
        return "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    }

    /**
     *
     * @return
     */
    public String getQuestionAndCorrectAnswer() {
        int number = RANDOM.nextInt(1, MAX_NUMBER); // Использование константы
        return number + ":" + (isPrime(number) ? "yes" : "no");
    }

    /**
     *
     * @param question
     * @return
     */
    public String getCorrectAnswer(String question) {
        String[] parts = question.split(":");
        return parts[1];
    }

    /**
     *
     * @param number
     * @return
     */
    private boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
