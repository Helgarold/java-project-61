package hexlet.code.games;

import hexlet.code.utils.Utils;
import hexlet.code.Engine;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс EvenGame реализует игру на определение четности числа.
 */
public final class EvenGame {

    private static final int MAX_NUMBER = 100;
    private static final int NUMBER_OF_ROUNDS = 3;

    /**
     * Возвращает приветственное сообщение.
     *
     * @return Приветственное сообщение о правилах игры.
     */
    public String getWelcomeMessage() {
        return "Answer 'yes' if the number is even, otherwise answer 'no'.";
    }

    /**
     * Определяет, является ли число четным.
     *
     * @param number число для проверки
     * @return true, если число четное, иначе false.
     */
    private boolean isEven(int number) {
        return number % 2 == 0;
    }

    /**
     * Генерирует вопрос и правильный ответ.
     *
     * @return массив, содержащий вопрос и правильный ответ.
     */
    public String[] getQuestionAndCorrectAnswer() {
        int number = Utils.getRandomInt(0, MAX_NUMBER);
        String question = String.valueOf(number);
        // Определяем правильный ответ: "yes" если четное, иначе "no"
        String correctAnswer = isEven(number) ? "yes" : "no";
        return new String[]{question, correctAnswer};
    }

    /**
     * Генерирует данные игры для указанного количества раундов.
     *
     * @param rounds количество игровых раундов
     * @return список массивов с вопросами и правильными ответами.
     */
    public List<String[]> getGameData(int rounds) {
        List<String[]> gameData = new ArrayList<>();
        for (int i = 0; i < rounds; i++) {
            gameData.add(getQuestionAndCorrectAnswer());
        }
        return gameData;
    }

    /**
     * Запускает игру.
     */
    public static void startGame() {
        EvenGame game = new EvenGame();
        String gameRules = game.getWelcomeMessage();
        List<String[]> gameData = game.getGameData(NUMBER_OF_ROUNDS);
        Engine.runGame(gameRules, gameData);
    }
}
