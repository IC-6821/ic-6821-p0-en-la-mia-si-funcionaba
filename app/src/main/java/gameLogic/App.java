package gameLogic;

import gameLogic.Game;
import players.HumanPlayer;

public class App{
    public static void main(String[] args) {
        Game game = new Game(args[1]);
        game.play();
    }
}
