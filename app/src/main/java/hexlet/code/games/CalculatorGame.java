package hexlet.code.games;

import java.util.Random;

public class CalculatorGame {
    private static final Random RANDOM = new Random();
    private static final String[] OPERATORS = {"+", "-", "*"};
    private static final int MAX_NUMBER = 100; // Константа для верхнего предела

    /**
     * Возвращает приветственное сообщение для игры.
     *
             * @return строка с приветственным сообщением о правилах игры.
     */
    public String getWelcomeMessage() {
        return "What is the result of the expression?";
    }

    /**
     * Генерирует вопрос для игры, состоящий из случайной арифметической операции с двумя числами.
     *
             * @return строку в формате "число оператор число", представляющую вопрос.
            */
    public String getQuestion() {
        int num1 = RANDOM.nextInt(MAX_NUMBER);
        int num2 = RANDOM.nextInt(MAX_NUMBER);
        String operator = OPERATORS[RANDOM.nextInt(OPERATORS.length)];
        return String.format("%d %s %d", num1, operator, num2);
    }

    /**
     * Получает правильный ответ на заданный вопрос.
            *
            * @param question строка, представляющая вопрос в формате "число оператор число".
            * @return строка, представляющая правильный ответ на вопрос.
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
