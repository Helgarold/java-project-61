package hexlet.code.games;

import hexlet.code.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class GcdGame {

    private static final int MAX_NUMBER = 100;
    private static final int MIN_NUMBER = 1;

    /**
     * Возвращает приветственное сообщение для игры.
     *
     * @return строка с указаниями для игрока о том, как отвечать.
     */
    public String getWelcomeMessage() {
        return "Find the greatest common divisor of given numbers.";
    }

    /**
     * Генерирует вопрос и правильный ответ для игры.
     *
     * @return массив строк, где первый элемент — это вопрос, а второй — правильный ответ.
     */
    public String[] getQuestionAndCorrectAnswer() {
        int num1 = Utils.getRandomInt(MIN_NUMBER, MAX_NUMBER + 1); // Генерация первого числа
        int num2 = Utils.getRandomInt(MIN_NUMBER, MAX_NUMBER + 1); // Генерация второго числа
        String question = num1 + " " + num2; // Формируем строку с вопросом
        String correctAnswer = String.valueOf(gcd(num1, num2)); // Вычисляем правильный ответ через НОД
        return new String[]{question, correctAnswer}; // Возвращаем в виде массива
    }

    /**
     * Генерирует данные для игры.
     *
     * @param rounds количество раундов (вопросов)
     * @return список строк массивов, содержащий вопрос и правильный ответ.
     */
    public List<String[]> getGameData(int rounds) {
        List<String[]> gameData = new ArrayList<>();
        for (int i = 0; i < rounds; i++) {
            gameData.add(getQuestionAndCorrectAnswer()); // Добавляем вопрос и ответ в список
        }
        return gameData;
    }

    /**
     * Вычисляет наибольший общий делитель (НОД) двух чисел.
     *
     * @param a первое число
     * @param b второе число
     * @return НОД двух чисел
     */
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
