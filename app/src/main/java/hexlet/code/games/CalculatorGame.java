package hexlet.code.games;

import java.util.Random;

public class CalculatorGame {
    private static final Random RANDOM = new Random();
    private static final String[] OPERATORS = {"+", "-", "*"};
    private static final int MAX_NUMBER = 100; // Константа для верхнего предела

    /*</strong>
            * Returns a welcome message for the game.
            * This method can be overridden in subclasses to provide a custom welcome message.
     *
             * @return a welcome message
     */
    public String getWelcomeMessage() {
        return "What is the result of the expression?";
    }

    /*<strong>
     * Generates a question for the game by performing a random operation
     * on two random numbers.
            * This method can be overridden to customize question generation.
     *
             * @return a string representing the question in the format "num1 operator num2"
            */
    public String getQuestion() {
        int num1 = RANDOM.nextInt(MAX_NUMBER);
        int num2 = RANDOM.nextInt(MAX_NUMBER);
        String operator = OPERATORS[RANDOM.nextInt(OPERATORS.length)];
        return String.format("%d %s %d", num1, operator, num2);
    }

    /*</strong>
            * Calculates the correct answer for the given question.
     * This method can be overridden in subclasses to handle custom operations.
     *
             * @param question the question string in the format "num1 operator num2"
            * @return the correct answer as a string
     */
    public String getCorrectAnswer(String question) {
        String[] parts = question.split(" ");
        int num1 = Integer.parseInt(parts[0]);
        String operator = parts[1];
        int num2 = Integer.parseInt(parts[2]);

        switch (operator) {
            case "+":
                return String.valueOf(num1 + num2);
            case "-":
                return String.valueOf(num1 - num2);
            case "*":
                return String.valueOf(num1 * num2);
            default:
                throw new IllegalArgumentException("Unknown operator: " + operator);
        }
    }
}
