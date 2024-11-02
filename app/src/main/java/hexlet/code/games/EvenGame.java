package hexlet.code.games;

import java.util.Random;

public class EvenGame {

    private static final Random RANDOM = new Random();
    private static final int MAX_NUMBER = 100; // Константа для верхнего предела случайного числа

    /**
     * Возвращает приветственное сообщение для игры.
     *
             * @return строка с указаниями для игрока о том, как отвечать.
            */
    public String getWelcomeMessage() {
        return "Answer 'yes' if the number is even, otherwise answer 'no'.";
    }

    /**
            * Генерирует случайное число для вопроса игры.
            *
            * @return строка, представляющая случайное число, которое будет использоваться в вопросе.
     */
    public String getQuestion() {
        int number = RANDOM.nextInt(MAX_NUMBER);
        return String.valueOf(number);
    }

    /**
     * Получает правильный ответ на заданный вопрос.
            *
            * @param question строка, представляющая случайное число.
            * @return boolean, true если число четное, и false если нечетное.
            */
    public boolean isEven(String question) {
        int number = Integer.parseInt(question);
        return number % 2 == 0;  // Возвращает true, если число четное
    }

    /**
            * Получает строку с правильным ответом на заданный вопрос.
            *
            * @param question строка, представляющая случайное число.
            * @return строка "yes" или "no", в зависимости от четности числа.
     */
    public String getCorrectAnswer(String question) {
        return isEven(question) ? "yes" : "no"; // Парсинг значения для представления в виде строки
    }
}