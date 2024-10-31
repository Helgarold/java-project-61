package hexlet.code.games;

import java.util.Random;

/*<strong>
 * Класс GcdGame представляет игру, где нужно найти наибольший общий делитель.
 */
public class GcdGame {
    private static final Random RANDOM = new Random();

    /*</strong>
            * Возвращает приветственное сообщение для игрока.
     *
             * Этот метод может быть переопределен в подклассах,
            * чтобы изменить приветственное сообщение.
            *
            * @return Приветственное сообщение.
            */
    protected String getWelcomeMessage() {
        return "Find the greatest common divisor of given numbers.";
    }
/*<strong>
     * Генерирует вопрос для игры, состоящий из двух случайных чисел.
            *
            * Этот метод может быть переопределен в подклассах,
            * если нужно изменить логику генерации вопроса.
            *
            * @return Строка с двумя числами.
            */
    public String getQuestion() {
        int num1 = RANDOM.nextInt(100) + 1; // Генерация числа от 1 до 100
        int num2 = RANDOM.nextInt(100) + 1; // Генерация числа от 1 до 100
        return num1 + " " + num2; // Возвращает строку с двумя числами
    }

    /*</strong>
            * Возвращает правильный ответ на заданный вопрос.
            *
            * @param question Вопрос, содержащий два числа.
            * @return Правильный ответ на вопрос.
            */
    public String getCorrectAnswer(String question) {
        String[] parts = question.split(" ");
        int num1 = Integer.parseInt(parts[0]);
        int num2 = Integer.parseInt(parts[1]);

        return String.valueOf(gcd(num1, num2)); // Возвращает НОД
    }

    // Метод для вычисления НОД
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
