package hexlet.code.games;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CalculatorGame {

    private static final Random RANDOM = new Random();
    private static final String[] OPERATORS = {"+", "-", "*"}; // Добавили оператор умножения
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
     * Генерирует вопрос и правильный ответ для игры.
     *
     * @return массив строк, где первый элемент — это вопрос, а второй — правильный ответ.
     */
    public String[] getQuestionAndCorrectAnswer() {
        int num1 = RANDOM.nextInt(MAX_NUMBER);
        int num2 = RANDOM.nextInt(MAX_NUMBER);
        String operator = OPERATORS[RANDOM.nextInt(OPERATORS.length)];
        String question = String.format("%d %s %d", num1, operator, num2);
        String correctAnswer = calculateAnswer(num1, operator, num2); // Вычисляем правильный ответ
        return new String[]{question, correctAnswer}; // Возвращаем в виде массива
    }

    /**
     * Генерирует данные для игры.
     *
     * @return список строк массивов, содержащий вопрос и правильный ответ.
     */
    public List<String[]> getGameData(int rounds) {
        List<String[]> gameData = new ArrayList<>();
        for (int i = 0; i < rounds; i++) {
            gameData.add(getQuestionAndCorrectAnswer());
        }
        return gameData;
    }

    /**
     * Вычисляет правильный ответ на выражение.
     *
     * @param num1    первый операнд.
     * @param operator оператор.
     * @param num2    второй операнд.
     * @return строка, представляющая правильный ответ на вопрос.
     */
    private String calculateAnswer(int num1, String operator, int num2) {
        switch (operator) {
            case "+":
                return String.valueOf(num1 + num2);
            case "-":
                return String.valueOf(num1 - num2);
            case "*":
                return String.valueOf(num1 * num2);
            default:
                throw new IllegalArgumentException("Unknown operator: " + operator); // Неизвестный оператор
        }
    }
}
