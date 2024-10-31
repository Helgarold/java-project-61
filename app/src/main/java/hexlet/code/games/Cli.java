package hexlet.code.games;

import java.util.Scanner;

public class Cli {
    public static void greetUser(Scanner scanner) {
        System.out.print("May I have your name? ");
        String name = scanner.nextLine();
        System.out.println("Hello, " + name + "!");
    }
}
