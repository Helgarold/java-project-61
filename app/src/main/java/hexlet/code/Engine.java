package hexlet.code;

import hexlet.code.Games.Game;
import java.util.Scanner;

public interface Engine {

    void runGame(Game game, String playerName, Scanner scanner);
}
