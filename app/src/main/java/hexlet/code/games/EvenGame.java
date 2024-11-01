package hexlet.code.games;

import java.util.Random;

public class EvenGame {
    private static final Random RANDOM = new Random();
    private static final int MAX_NUMBER = 100; // Константа для верхнего предела случайного числа

    /**
     *
     * @return
     */
    public String getWelcomeMessage() {
        return "Answer 'yes' if the number is even, otherwise answer 'no'.";
    }

    /**
     *
     * @return
     */
    public String getQuestion() {
        int number = RANDOM.nextInt(MAX_NUMBER);
        return String.valueOf(number);
    }

    /**
     *
     * @param question
     * @return
     */
    public String getCorrectAnswer(String question) {
        int number = Integer.parseInt(question);
        return (number % 2 == 0) ? "yes" : "no";
    }
}
