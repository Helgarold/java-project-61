package hexlet.code;

import java.util.Random;
import java.util.Scanner;

public class EvenGame {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();

    public static void startGame() {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String name = scanner.nextLine();
        System.out.println("Hello, " + name + "!");
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        int correctAnswers = 0;

        while (correctAnswers < 3) {
            int question = random.nextInt(100);
            System.out.println("Question: " + question);
            System.out.print("Your answer: ");
            String answer = scanner.nextLine();
            String correctAnswer = (question % 2 == 0) ? "yes" : "no";

            if (answer.equals(correctAnswer)) {
                System.out.println("Correct!");
                correctAnswers++;
            } else {
                System.out.printf("'%s' is wrong answer ;(. Correct answer was '%s'.\n", answer, correctAnswer);
                System.out.printf("Let's try again, %s!\n", name);
                return; // Завершение игры при неверном ответе
            }
        }

        System.out.printf("Congratulations, %s!\n", name);
    }
}
