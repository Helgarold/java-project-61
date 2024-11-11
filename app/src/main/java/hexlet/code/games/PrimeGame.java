package hexlet.code.games;

import hexlet.code.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class PrimeGame {
    private static final int MAX_NUMBER = 100;

    /**
    Возвращает приветственное сообщение для игры.

    @return строка с приветственным сообщением, объясняющим правила игры
     */
    public String getWelcomeMessage() {
        return "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    }

    /**
    Генерирует вопрос и правильный ответ для игры.

    @return массив строк, где первый элемент — это вопрос, а второй — правильный ответ.
            */
    public String[] getQuestionAndCorrectAnswer() {
        int number = Utils.getRandomInt(1, MAX_NUMBER + 1); // Генерация случайного числа
        String correctAnswer = isPrime(number) ? "yes" : "no"; // Определяем правильный ответ
        return new String[]{String.valueOf(number), correctAnswer}; // Возвращаем в виде массива
    }

    /**
    Генерирует данные для игры.

    @param rounds количество раундов (вопросов)
      @return список строк массивов, содержащий вопрос и правильный ответ.
     */
    public List<String[]> getGameData(int rounds) {
        List<String[]> gameData = new ArrayList<>();
        for (int i = 0; i < rounds; i++) {
            gameData.add(getQuestionAndCorrectAnswer()); // Добавляем вопрос и ответ в список
        }
        return gameData;
    }

    /**
    Проверяет, является ли число простым.

    @param number число, которое нужно проверить
      @return true, если число простое; false в противном случае
    */
    private boolean isPrime(int number) {
        if (number < 2) {
            return false; // Числа меньше 2 не являются простыми
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false; // Найден делитель
            }
        }
        return true; // Число является простым
    }
}
