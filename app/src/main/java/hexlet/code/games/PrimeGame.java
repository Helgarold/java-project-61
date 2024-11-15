package hexlet.code.games;

import hexlet.code.utils.Utils;
import hexlet.code.Engine;

import java.util.ArrayList;
import java.util.List;

public class PrimeGame {

    private static final int MAX_NUMBER = 100;
    private static final int NUMBER_OF_ROUNDS = 3; // Константа для количества раундов

    public static void startGame() {
        // Получаем приветственное сообщение
        String welcomeMessage = getWelcomeMessage();
        // Получаем данные для игры
        List<String[]> gameData = getGameData(NUMBER_OF_ROUNDS); // Используем константу
        // Запускаем игру
        Engine.runGame(welcomeMessage, gameData);
    }

    public static String getWelcomeMessage() {
        return "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    }

    public static String[] getQuestionAndCorrectAnswer() {
        int number = Utils.getRandomInt(1, MAX_NUMBER + 1);
        String correctAnswer = isPrime(number) ? "yes" : "no";
        return new String[]{String.valueOf(number), correctAnswer};
    }

    public static List<String[]> getGameData(int rounds) {
        List<String[]> gameData = new ArrayList<>();
        for (int i = 0; i < rounds; i++) {
            gameData.add(getQuestionAndCorrectAnswer());
        }
        return gameData;
    }

    private static boolean isPrime(int number) {
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
