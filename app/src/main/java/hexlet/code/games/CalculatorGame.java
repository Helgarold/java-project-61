package hexlet.code.games;

import java.util.Random;

public class CalculatorGame {
    private static final Random RANDOM = new Random();
    private static final String[] OPERATORS = {"+", "-", "*"};

    public String getWelcomeMessage() {
        return "What is the result of the expression?";
    }

    public String getQuestion() {
        int num1 = RANDOM.nextInt(100);
        int num2 = RANDOM.nextInt(100);
        String operator = OPERATORS[RANDOM.nextInt(OPERATORS.length)];
        return String.format("%d %s %d", num1, operator, num2);
    }

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