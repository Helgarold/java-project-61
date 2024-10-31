package hexlet.code.games;

import java.util.Random;

public class EvenGame {
    private static final Random RANDOM = new Random();
    private static final int MAX_NUMBER = 100; // Константа для верхнего предела случайного числа

    /*<strong>
     * Returns a welcome message for the game.
            * This method can be overridden in subclasses to provide a custom welcome message.
     *
             * @return a welcome message
     */
    public String getWelcomeMessage() {
        return "Answer 'yes' if the number is even, otherwise answer 'no'.";
    }

    /*</strong>
            * Generates a question for the game by generating a random number.
     * This method can be overridden to customize question generation logic.
            *
            * @return the generated question as a string
     */
    public String getQuestion() {
        int number = RANDOM.nextInt(MAX_NUMBER);
        return String.valueOf(number);
    }

    /*<strong>
     * Calculates the correct answer for the given question.
     * This method can be overridden in subclasses to handle custom answer logic.
            *
            * @param question the question string representing the number
     * @return the correct answer as a string
     */
    public String getCorrectAnswer(String question) {
        int number = Integer.parseInt(question);
        return (number % 2 == 0) ? "yes" : "no";
    }
}
