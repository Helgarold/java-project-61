package hexlet.code.games;

import hexlet.code.utils.Utils;
import hexlet.code.Engine; // Импортируем класс Engine для запуска игры

import java.util.ArrayList;
import java.util.List;

public class PrimeGame {

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
        return "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    }

    public static String[] getQuestionAndCorrectAnswer() {
        int number = Utils.getRandomInt(1, MAX_NUMBER + 1); // Генерация случайного числа
        String correctAnswer = isPrime(number) ? "yes" : "no"; // Определяем правильный ответ
        return new String[]{String.valueOf(number), correctAnswer}; // Возвращаем в виде массива
    }

    public static List<String[]> getGameData(int rounds) {
        List<String[]> gameData = new ArrayList<>();
        for (int i = 0; i < rounds; i++) {
            gameData.add(getQuestionAndCorrectAnswer()); // Добавляем вопрос и ответ в список
        }
        return gameData;
    }

    private static boolean isPrime(int number) {
        if (number < 2) {
            return false; // Числа меньше 2 не являются простыми
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false; // Найден делитель
            }
        }
        return true; // Число является простым
    }
}
