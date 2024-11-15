package hexlet.code.games;

import hexlet.code.utils.Utils;
import hexlet.code.Engine; // Импортируем класс Engine для запуска игры

import java.util.ArrayList;
import java.util.List;

public class GcdGame {

    private static final int MAX_NUMBER = 100;
    private static final int MIN_NUMBER = 1;

    public static void startGame() {
        // Получаем приветственное сообщение
        String welcomeMessage = getWelcomeMessage();
        // Получаем данные для игры
        List<String[]> gameData = getGameData(3); // 3 раунда
        // Запускаем игру
        Engine.runGame(welcomeMessage, gameData);
    }

    public static String getWelcomeMessage() {
        return "Find the greatest common divisor of given numbers.";
    }

    public static String[] getQuestionAndCorrectAnswer() {
        int num1 = Utils.getRandomInt(MIN_NUMBER, MAX_NUMBER + 1); // Генерация первого числа
        int num2 = Utils.getRandomInt(MIN_NUMBER, MAX_NUMBER + 1); // Генерация второго числа
        String question = num1 + " " + num2; // Формируем строку с вопросом
        String correctAnswer = String.valueOf(gcd(num1, num2)); // Вычисляем правильный ответ через НОД
        return new String[]{question, correctAnswer}; // Возвращаем в виде массива
    }

    public static List<String[]> getGameData(int rounds) {
        List<String[]> gameData = new ArrayList<>();
        for (int i = 0; i < rounds; i++) {
            gameData.add(getQuestionAndCorrectAnswer()); // Добавляем вопрос и ответ в список
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
