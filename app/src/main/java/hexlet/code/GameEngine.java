package hexlet.code;

import hexlet.code.Games.Game;
import java.util.Scanner;


public class GameEngine implements Engine {
    @Override
    public void runGame(Game game, String playerName, Scanner scanner) {
        if (game == null || playerName == null || playerName.trim().isEmpty()) {
            throw new IllegalArgumentException("Неверные параметры: игра и имя игрока не могут быть null или пустыми.");
        }

        System.out.println("Начинаем игру, " + playerName + "!");
        try {
            game.start(scanner, playerName);
        } catch (Exception e) {
            System.out.println("Произошла ошибка при запуске игры: " + e.getMessage());
        }
    }
}