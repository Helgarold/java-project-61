package hexlet.code.Games;

import java.util.Scanner;
import java.util.Random;

public class EvenGame implements Game {
    private final Cli cli;
    private final Random random;

    public EvenGame(Cli cli) {
        this.cli = cli;
        this.random = new Random(); // Инициализация Random один раз
    }

    @Override
    public void start(Scanner scanner, String playerName) {
        cli.displayMessage(playerName + ", давай сыграем в игру Четные / Нечетные!");
        cli.displayMessage("Правила: Ответьте 'yes', если число четное, и 'no', если нет.");

        for (int round = 0; round < 3; round++) {
            int number = random.nextInt(100) + 1; // Случайное число от 1 до 100
            cli.displayMessage("Раунд " + (round + 1) + ": " + number);

            String answer;
            while (true) {
                cli.displayMessage("Это четное число? (yes/no): ");
                answer = scanner.next();

                if (answer.equals("yes") || answer.equals("no")) {
                    break; // выходим из цикла, если ответ корректный
                } else {
                    cli.displayMessage("Некорректный ввод! Пожалуйста, введите 'yes' или 'no'.");
                }
            }

            String correctAnswer = (number % 2 == 0) ? "yes" : "no";

            if (answer.equals(correctAnswer)) {
                cli.displayMessage("Правильно!");
            } else {
                cli.displayMessage("Неправильно! Правильный ответ: " + correctAnswer);
                cli.displayMessage(String.format("Попробуйте еще раз, %s!", playerName));
                return; // Завершаем игру при неправильном ответе
            }
        }

        cli.displayMessage(String.format("Поздравляем, %s!", playerName)); // Поздравляем игрока после всех раундов
    }
}