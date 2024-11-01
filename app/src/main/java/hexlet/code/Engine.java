package hexlet.code;

import hexlet.code.games.EvenGame;
import hexlet.code.games.CalculatorGame;
import hexlet.code.games.GcdGame;
import hexlet.code.games.ProgressionGame;
import hexlet.code.games.PrimeGame;
import java.util.Scanner;

public class Engine {
    private static final int MAX_ROUNDS = 3;

    /**
     *
     * @param game
     */
    public static void runGame(Object game) {
        if (!(game instanceof EvenGame
                || game instanceof CalculatorGame
                || game instanceof GcdGame
                || game instanceof ProgressionGame
                || game instanceof PrimeGame)) {
            throw new IllegalArgumentException("Unknown game type");
        }

        try (Scanner scanner = new Scanner(System.in)) {
            String welcomeMessage;

            if (game instanceof EvenGame) {
                welcomeMessage = ((EvenGame) game).getWelcomeMessage();
            } else if (game instanceof CalculatorGame) {
                welcomeMessage = ((CalculatorGame) game).getWelcomeMessage();
            } else if (game instanceof GcdGame) {
                welcomeMessage = ((GcdGame) game).getWelcomeMessage();
            } else if (game instanceof ProgressionGame) {
                welcomeMessage = ((ProgressionGame) game).getWelcomeMessage();
            } else {
                welcomeMessage = ((PrimeGame) game).getWelcomeMessage();
            }

            System.out.println(welcomeMessage);
            System.out.print("May I have your name? ");
            String name = scanner.nextLine();
            System.out.println("Hello, " + name + "!");

            for (int round = 0; round < MAX_ROUNDS; round++) {
                String question;
                String correctAnswer;

                if (game instanceof EvenGame) {
                    question = ((EvenGame) game).getQuestion();
                    correctAnswer = ((EvenGame) game).getCorrectAnswer(question);
                } else if (game instanceof CalculatorGame) {
                    question = ((CalculatorGame) game).getQuestion();
                    correctAnswer = ((CalculatorGame) game).getCorrectAnswer(question);
                } else if (game instanceof GcdGame) {
                    question = ((GcdGame) game).getQuestion();
                    correctAnswer = ((GcdGame) game).getCorrectAnswer(question);
                } else if (game instanceof ProgressionGame) {
                    String questionAndAnswer = ((ProgressionGame) game).getQuestionAndCorrectAnswer();
                    question = questionAndAnswer.split(":")[0];
                    correctAnswer = ((ProgressionGame) game).getCorrectAnswer(questionAndAnswer);
                } else {
                    String questionAndAnswer = ((PrimeGame) game).getQuestionAndCorrectAnswer();
                    question = questionAndAnswer.split(":")[0];
                    correctAnswer = ((PrimeGame) game).getCorrectAnswer(questionAndAnswer);
                }

                System.out.println("Question: " + question);
                System.out.print("Your answer: ");
                String userAnswer = scanner.nextLine();

                if (!userAnswer.equals(correctAnswer)) {
                    System.out.printf("'%s' is wrong answer ;(. Correct answer was '%s'.\n", userAnswer, correctAnswer);
                    System.out.printf("Let's try again, %s!\n", name);
                    return; // Завершение после неправильного ответа
                }

                System.out.println("Correct!");
            }

            System.out.printf("Congratulations, %s!\n", name); // Поздравление после успешной игры
        }
    }
}
