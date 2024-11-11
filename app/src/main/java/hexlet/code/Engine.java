package hexlet.code;

import java.util.List;
import java.util.Scanner;

public class Engine {
    private static final int MAX_ROUNDS = 3;

    /**
     * Запускает игру.
     *
     * @param gameRules правила игры
     * @param gameData  список пар вопрос-ответ
     */
    public static void runGame(String gameRules, List<String[]> gameData) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println(gameRules);
            System.out.print("May I have your name? ");
            String name = scanner.nextLine();
            System.out.println("Hello, " + name + "!");

            for (int round = 0; round < MAX_ROUNDS; round++) {
                String question = gameData.get(round)[0]; // Получаем вопрос
                String correctAnswer = gameData.get(round)[1]; // Получаем правильный ответ

                System.out.println("Question: " + question);
                System.out.print("Your answer: ");
                String userAnswer = scanner.nextLine();

                if (!userAnswer.equals(correctAnswer)) {
                    System.out.printf("'%s' is wrong answer ;(. Correct answer was '%s'.\n",
                            userAnswer, correctAnswer);
                    System.out.printf("Let's try again, %s!\n", name);
                    return; // Завершение после неправильного ответа
                }

                System.out.println("Correct!");
            }

            System.out.printf("Congratulations, %s!\n", name);
        }
    }
}
