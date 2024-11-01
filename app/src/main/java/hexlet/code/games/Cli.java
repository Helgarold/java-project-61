package hexlet.code.games;

import java.util.Scanner;

/**
 * Класс, содержащий методы для взаимодействия с пользователем.
        */
public class Cli {

    /**
            * Запрашивает имя пользователя и приветствует его.
            *
            * @param scanner объект типа Scanner для получения ввода от пользователя.
     */
    public static void greetUser(Scanner scanner) {
        System.out.print("May I have your name? ");
        String name = scanner.nextLine();
        System.out.println("Hello, " + name + "!");
    }
}
