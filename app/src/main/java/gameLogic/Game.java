package gameLogic;

import board.GameBoard;
import players.ComputerPlayer;
import players.HumanPlayer;
import players.Player;
import gameUserInterface.TerminalDesign;

public class Game {

    // The game is going to use 4 objects, so we declare them inside the main Game class

    private TerminalDesign terminalDesign;
    private GameBoard gameBoard;
    private Player humanPlayer;
    private Player computerPlayer;

    public Game(String difficulty) { // Parametered constructor

        this.terminalDesign = new TerminalDesign();
        this.gameBoard = new GameBoard();
        this.humanPlayer = new HumanPlayer('X');
        this.computerPlayer = new ComputerPlayer('O', difficulty); // Difficulty was given by user input in the main function "String[] args"

    }

    public void Play() { // Function that dictates the flow of the game
        terminalDesign.showGame(gameBoard.BoardCellsToString());
        Boolean isValid = false;
        // Player turn
        do{
            Integer[] positions = humanPlayer.makeMove();
            isValid = gameBoard.placeMove(positions[0], positions[1], SYMBOL);
        }while (isValid);

    }
}