package hexlet.code.games;

import java.util.Random;

public class ProgressionGame {
    private static final Random RANDOM = new Random();
    private static final int MIN_LENGTH = 5;
    private static final int MAX_LENGTH = 10;
    private static final int PROGRESSION_START = 1;
    private static final int PROGRESSION_STEP = 2;
    private static final int MAX_START_NUMBER = 20; // Константа для верхнего предела начального числа

    /**
     *
     * @return
     */
    public String getWelcomeMessage() {
        return "What number is missing in the progression?";
    }

    /**
     *
     * @return
     */
    public String getQuestionAndCorrectAnswer() {
        int length = RANDOM.nextInt(MAX_LENGTH - MIN_LENGTH + 1) + MIN_LENGTH;
        int start = RANDOM.nextInt(PROGRESSION_START, MAX_START_NUMBER);
        int hiddenIndex = RANDOM.nextInt(length);

        StringBuilder progression = new StringBuilder();
        int hiddenNumber = 0;

        for (int i = 0; i < length; i++) {
            int currentNumber = start + i * PROGRESSION_STEP;
            if (i == hiddenIndex) {
                progression.append(".. ");
                hiddenNumber = currentNumber;
            } else {
                progression.append(currentNumber).append(" ");
            }
        }

        return progression.toString().trim() + ":" + hiddenNumber;
    }

    /**
     *
     * @param question
     * @return
     */
    public String getCorrectAnswer(String question) {
        String[] parts = question.split(":");
        return parts[1];
    }
}
