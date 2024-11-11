package hexlet.code.games;

import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class ProgressionGame {
    private static final Random RANDOM = new Random();
    private static final int MIN_LENGTH = 5;
    private static final int MAX_LENGTH = 10;
    private static final int PROGRESSION_START = 1;
    private static final int PROGRESSION_STEP = 2;
    private static final int MAX_START_NUMBER = 20;

    /**
     * Возвращает приветственное сообщение для игры.
     *
     * @return строка с приветственным сообщением.
     */
    public String getWelcomeMessage() {
        return "What number is missing in the progression?";
    }

    /**
     * Генерирует вопрос и скрытое число в последовательности прогрессии.
     *
     * @return массив строк, где первый элемент — это вопрос, а второй — правильный ответ.
     */
    public String[] getQuestionAndCorrectAnswer() {
        int length = RANDOM.nextInt(MAX_LENGTH - MIN_LENGTH + 1) + MIN_LENGTH;
        int start = RANDOM.nextInt(PROGRESSION_START, MAX_START_NUMBER);
        int hiddenIndex = RANDOM.nextInt(length);

        List<String> progression = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            int currentNumber = start + i * PROGRESSION_STEP;
            progression.add(String.valueOf(currentNumber));
        }

        // Сохраняем скрытое число
        String hiddenNumber = progression.get(hiddenIndex);
        progression.set(hiddenIndex, ".."); // Заменяем на ".."

        String progressionString = String.join(" ", progression);
        return new String[]{progressionString, hiddenNumber};
    }

    /**
     * Генерирует данные для игры.
     *
     * @param rounds количество раундов (вопросов)
     * @return список строк массивов, содержащий вопрос и правильный ответ.
     */
    public List<String[]> getGameData(int rounds) {
        List<String[]> gameData = new ArrayList<>();
        for (int i = 0; i < rounds; i++) {
            gameData.add(getQuestionAndCorrectAnswer()); // Добавляем вопрос и ответ в список
        }
        return gameData;
    }
}
