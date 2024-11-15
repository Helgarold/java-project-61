package hexlet.code.games;

import hexlet.code.utils.Utils;
import hexlet.code.Engine; // Предполагается, что вы импортируете Engine
import java.util.ArrayList;
import java.util.List;

public class CalculatorGame {

    private static final char[] OPERATORS = {'+', '-', '*'};
    private static final int MAX_NUMBER = 100;

    public static void startGame() {
        // Получаем приветственное сообщение
        String welcomeMessage = getWelcomeMessage();
        // Получаем данные для игры
        List<String[]> gameData = getGameData(3); // 3 раунда
        // Запускаем игру
        Engine.runGame(welcomeMessage, gameData);
    }

    public static String getWelcomeMessage() {
        return "What is the result of the expression?";
    }

    public static String[] getQuestionAndCorrectAnswer() {
        int num1 = Utils.getRandomInt(0, MAX_NUMBER);
        int num2 = Utils.getRandomInt(0, MAX_NUMBER);
        char operator = getRandomOperator();
        String question = String.format("%d %c %d", num1, operator, num2);
        int correctAnswer = calculateAnswer(num1, operator, num2);
        return new String[]{question, String.valueOf(correctAnswer)};
    }

    public static List<String[]> getGameData(int rounds) {
        List<String[]> gameData = new ArrayList<>();
        for (int i = 0; i < rounds; i++) {
            gameData.add(getQuestionAndCorrectAnswer());
        }
        return gameData;
    }

    private static int calculateAnswer(int num1, char operator, int num2) {
        switch (operator) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            default:
                throw new IllegalArgumentException("Unknown operator: " + operator);
        }
    }

    private static char getRandomOperator() {
        return OPERATORS[Utils.getRandomInt(0, OPERATORS.length)];
    }
}
