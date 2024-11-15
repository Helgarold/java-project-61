package hexlet.code.games;

import hexlet.code.utils.Utils; // Не забудь импортировать класс Utils
import hexlet.code.Engine;
import java.util.ArrayList;
import java.util.List;

public class EvenGame {

    private static final int MAX_NUMBER = 100;
    private static final int NUMBER_OF_ROUNDS = 3; // Константа для числа вопросов

    public String getWelcomeMessage() {
        return "Answer 'yes' if the number is even, otherwise answer 'no'.";
    }

    private boolean isEven(int number) {
        return number % 2 == 0;
    }

    public String[] getQuestionAndCorrectAnswer() {
        int number = Utils.getRandomInt(0, MAX_NUMBER);
        String question = String.valueOf(number);
        String correctAnswer = isEven(number) ? "yes" : "no";
        return new String[]{question, correctAnswer};
    }

    public List<String[]> getGameData(int rounds) {
        List<String[]> gameData = new ArrayList<>();
        for (int i = 0; i < rounds; i++) {
            gameData.add(getQuestionAndCorrectAnswer());
        }
        return gameData;
    }

    public static void startGame() {
        EvenGame game = new EvenGame();
        String gameRules = game.getWelcomeMessage();
        List<String[]> gameData = game.getGameData(NUMBER_OF_ROUNDS);
        Engine.runGame(gameRules, gameData);
    }
}
