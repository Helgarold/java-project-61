package hexlet.code.games;

import java.util.Random;

public class PrimeGame {
    private static final Random RANDOM = new Random();
    private static final int MAX_NUMBER = 100; // Константа для верхнего предела

    /*<strong>
     * Returns a welcome message for the game.
            * This method can be overridden in subclasses to provide a custom welcome message.
     *
             * @return a welcome message
     */
    public String getWelcomeMessage() {
        return "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    }

    /*</strong>
            * Generates a random number and returns a question along with the correct answer.
     * This method can be overridden in subclasses to provide custom question generation logic.
     *
             * @return a string in the format <question>:<correct_answer>
     */
    public String getQuestionAndCorrectAnswer() {
        int number = RANDOM.nextInt(1, MAX_NUMBER); // Использование константы
        return number + ":" + (isPrime(number) ? "yes" : "no");
    }

    /*<strong>
     * Extracts the correct answer from the question string.
            * This method can be useful in subclasses that need to derive the correct answer from the question format.
            *
            * @param question the question string in the format <question>:<correct_answer>
     * @return the correct answer as a string
     */
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
