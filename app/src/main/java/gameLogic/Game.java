package gameLogic;

import board.GameBoard;
import players.ComputerPlayer;
import players.HumanPlayer;
import players.Player;

public class Game {
    private GameBoard gameBoard;
    private Player humanPlayer;
    private Player computerPlayer;

    public Game(String difficulty) {
        this.gameBoard = new GameBoard();
        this.humanPlayer = new HumanPlayer('X');
        this.computerPlayer = new ComputerPlayer('O', difficulty);
    }

    public void play() {

    }
}

