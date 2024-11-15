package hexlet.code.games;

import hexlet.code.utils.Utils;
import hexlet.code.Engine;

import java.util.ArrayList;
import java.util.List;

public class GcdGame {

    private static final int MAX_NUMBER = 100;
    private static final int MIN_NUMBER = 1;
    private static final int NUMBER_OF_ROUNDS = 3;

    public static void startGame() {
        // Получаем приветственное сообщение
        String welcomeMessage = getWelcomeMessage();
        // Получаем данные для игры
        List<String[]> gameData = getGameData(NUMBER_OF_ROUNDS);
        // Запускаем игру
        Engine.runGame(welcomeMessage, gameData);
    }

    public static String getWelcomeMessage() {
        return "Find the greatest common divisor of given numbers.";
    }

    public static String[] getQuestionAndCorrectAnswer() {
        int num1 = Utils.getRandomInt(MIN_NUMBER, MAX_NUMBER + 1);
        int num2 = Utils.getRandomInt(MIN_NUMBER, MAX_NUMBER + 1);
        String question = num1 + " " + num2;
        String correctAnswer = String.valueOf(gcd(num1, num2));
        return new String[]{question, correctAnswer};
    }

    public static List<String[]> getGameData(int rounds) {
        List<String[]> gameData = new ArrayList<>();
        for (int i = 0; i < rounds; i++) {
            gameData.add(getQuestionAndCorrectAnswer());
        }
        return gameData;
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
