package hexlet.code.Games;

import java.util.Scanner;
import java.util.Random;

public class EvenGame implements Game {
    private final Cli cli;

    public EvenGame(Cli cli) {
        this.cli = cli;
    }

    @Override
    public void start(Scanner scanner, String playerName) {
        cli.displayMessage(playerName + ", давай сыграем в игру Четные / Нечетные!");
        System.out.println("Правила: Ответьте 'yes', если число четное, и 'no', если нет.");

        for (int round = 0; round < 3; round++) {
            int number = new Random().nextInt(100);
            System.out.println("Раунд " + (round + 1) + ": " + number);
            System.out.print("Это четное число? (yes/no): ");
            String answer = scanner.next();
            String correctAnswer = (number % 2 == 0) ? "yes" : "no";

            if (answer.equals(correctAnswer)) {
                System.out.println("Правильно!");
            } else {
                System.out.println("Неправильно! Правильный ответ: " + correctAnswer);
                System.out.printf("Попробуйте еще раз, %s!%n", playerName);
                return; // Завершаем игру при неправильном ответе
            }
        }

        System.out.printf("Поздравляем " +  playerName + "!" + '\n');// Поздравляем игрока после всех раундов

    }
}