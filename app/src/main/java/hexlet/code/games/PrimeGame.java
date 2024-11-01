package hexlet.code.games;

import java.util.Random;

public class PrimeGame {
    private static final Random RANDOM = new Random();
    private static final int MAX_NUMBER = 100; // Константа для верхнего предела

    /**
     * Возвращает приветственное сообщение для игры.
     *
             * @return строка с приветственным сообщением, объясняющим правила игры
     */
    public String getWelcomeMessage() {
        return "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    }

    /**
            * Генерирует вопрос и правильный ответ для игры.
     *
             * @return строка, представляющая сгенерированное число и правильный ответ, разделенные двоеточием
     */
    public String getQuestionAndCorrectAnswer() {
        int number = RANDOM.nextInt(1, MAX_NUMBER); // Использование константы
        return number + ":" + (isPrime(number) ? "yes" : "no");
    }

    /**
     * Получает правильный ответ на вопрос.
     *
             * @param question строка с вопросом, содержащая число и ожидаемый ответ
     * @return строка с правильным ответом "yes" или "no"
            */
    public String getCorrectAnswer(String question) {
        String[] parts = question.split(":");
        return parts[1]; // Возвращает правильный ответ, который был сгенерирован
    }

    /**
            * Проверяет, является ли число простым.
            *
            * @param number число, которое нужно проверить
     * @return true, если число простое; false в противном случае
     */
    private boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
