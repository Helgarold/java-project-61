package hexlet.code.games;

import hexlet.code.utils.Utils;
import hexlet.code.Engine; // Импортируем класс Engine для запуска игры

import java.util.ArrayList;
import java.util.List;

public class ProgressionGame {

    private static final int MAX_NUMBER = 100;
    private static final int MIN_NUMBER = 1;
    private static final int PROGRESSION_LENGTH = 10; // Длина прогрессии

    public static void startGame() {
        // Получаем приветственное сообщение
        String welcomeMessage = getWelcomeMessage();
        // Получаем данные для игры
        List<String[]> gameData = getGameData(3); // 3 раунда
        // Запускаем игру
        Engine.runGame(welcomeMessage, gameData);
    }

    public static String getWelcomeMessage() {
        return "What number is missing in the progression?";
    }

    public static String[] getQuestionAndCorrectAnswer() {
        int start = Utils.getRandomInt(MIN_NUMBER, MAX_NUMBER); // Начальное число прогрессии
        int step = Utils.getRandomInt(MIN_NUMBER, MAX_NUMBER / 10); // Шаг прогрессии
        int missingIndex = Utils.getRandomInt(0, PROGRESSION_LENGTH); // Индекс пропущенного числа
        StringBuilder question = new StringBuilder();

        for (int i = 0; i < PROGRESSION_LENGTH; i++) {
            int currentNumber = start + (i * step);
            if (i == missingIndex) {
                question.append(".. "); // Заменяем пропущенное число на ".."
            } else {
                question.append(currentNumber).append(" ");
            }
        }

        // Правильный ответ - это пропущенное число
        int correctAnswer = start + (missingIndex * step);
        return new String[]{question.toString().trim(), String.valueOf(correctAnswer)};
        // Возвращаем массив с вопросом и ответом
    }

    public static List<String[]> getGameData(int rounds) {
        List<String[]> gameData = new ArrayList<>();
        for (int i = 0; i < rounds; i++) {
            gameData.add(getQuestionAndCorrectAnswer()); // Добавляем вопрос и ответ в список
        }
        return gameData;
    }
}
