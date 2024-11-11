package hexlet.code.games;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EvenGame {

    private static final Random RANDOM = new Random();
    private static final int MAX_NUMBER = 100;

    /**
     * Возвращает приветственное сообщение для игры.
     *
     * @return строка с указаниями для игрока о том, как отвечать.
     */
    public String getWelcomeMessage() {
        return "Answer 'yes' if the number is even, otherwise answer 'no'.";
    }

    /**
     * Генерирует вопрос и правильный ответ для игры.
     *
     * @return массив строк, где первый элемент — это вопрос, а второй — правильный ответ.
     */
    public String[] getQuestionAndCorrectAnswer() {
        int number = RANDOM.nextInt(MAX_NUMBER);
        String question = String.valueOf(number);
        String correctAnswer = (number % 2 == 0) ? "yes" : "no"; // Определяем правильный ответ
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
}
