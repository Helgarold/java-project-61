package hexlet.code.utils;

import java.util.Random;

public class Utils {
    private static Random random = new Random();

    public static int getRandomInt(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("Минимальное значение должно быть меньше максимального.");
        }
        return random.nextInt((max - min)) + min; // Генерация случайного числа в диапазоне [min, max)
    }
}
