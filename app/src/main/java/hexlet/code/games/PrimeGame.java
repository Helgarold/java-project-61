package hexlet.code.games;

import java.util.Random;

public class PrimeGame {
    private static final Random RANDOM = new Random();

    public String getWelcomeMessage() {
        return "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    }

    public String getQuestionAndCorrectAnswer() {
        int number = RANDOM.nextInt(1, 100);
        return number + ":" + (isPrime(number) ? "yes" : "no");
    }

    public String getCorrectAnswer(String question) {
        String[] parts = question.split(":");
        return parts[1];
    }

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
