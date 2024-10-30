package hexlet.code;

import hexlet.code.Games.Game;
import java.util.Scanner;

public class GameEngine implements Engine {
    @Override
    public void runGame(Game game, String playerName, Scanner scanner) {
        if (game == null || playerName == null || playerName.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid parameters: game and player name cannot be null or empty.");
        }

        System.out.println("Starting the game, " + playerName + "!");
        try {
            game.start(scanner, playerName);
        } catch (Exception e) {
            System.out.println("An error occurred while starting the game: " + e.getMessage());
        }
    }
}