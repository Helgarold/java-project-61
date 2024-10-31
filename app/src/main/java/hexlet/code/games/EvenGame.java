package hexlet.code.games;

import java.util.Random;

public class EvenGame {
    private static final Random RANDOM = new Random();

    public String getWelcomeMessage() {
        return "Answer 'yes' if the number is even, otherwise answer 'no'.";
    }

    public String getQuestion() {
        int number = RANDOM.nextInt(100);
        return String.valueOf(number);
    }

    public String getCorrectAnswer(String question) {
        int number = Integer.parseInt(question);
        return (number % 2 == 0) ? "yes" : "no";
    }
}