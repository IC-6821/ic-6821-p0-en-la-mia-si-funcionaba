package gamelogic;

import board.GameBoard;
import players.ComputerPlayer;
import players.HumanPlayer;
import players.Player;
import gameuserinterface.TerminalUI;
import gameuserinterface.UI;

public class Game {

    // The game is going to use 4 objects, so we declare them inside the main Game
    // class

    private UI gameUI;
    private GameBoard gameBoard;
    private Player humanPlayer;
    private Player computerPlayer;

    private final int HUMANPLAYER_MOVE_INVALID_EXCEPTION = 001;
    private final int HUMANPLAYER_MOVE_OCCUPIED_EXCEPTION = 002;
    private final int HUMANPLAYER_INPUT_INVALID_EXCEPTION = 003;

    public Game(String difficulty) { // Parametered constructor

        this.gameUI = new TerminalUI();
        this.gameBoard = new GameBoard();
        this.humanPlayer = new HumanPlayer('X');
        this.computerPlayer = new ComputerPlayer('O', difficulty); // Difficulty was given by user input in the main
        // function "String[] args"

    }

    public void play() { // Function that dictates the flow of the game

        int turn = 0;

        while (turn < 9) {

            gameUI.showGame(gameBoard.boardCellsToString());

            switch (turn % 2) { // alternates between player and computer turns
                case 0:

                    humanPlayerMove('X');
                    turn++;
                    if (gameBoard.CheckGameWin('X')) {
                        gameUI.showGame(gameBoard.boardCellsToString());
                        gameUI.displayWinMessage();
                        turn = 10;
                    }
                    break;

                case 1:

                    computerPlayerMove('O');
                    turn++;
                    if (gameBoard.CheckGameWin('O')) {
                        gameUI.showGame(gameBoard.boardCellsToString());
                        gameUI.displayLoseMessage();
                        turn = 10;
                    }
                    break;
            }
        }
        if (turn == 9) {
            gameUI.displayTieMessage();
        }
    }

    private void humanPlayerMove(char playerSymbol) {

        boolean validMove = false;

        while (!validMove) {

            int[] positions = humanPlayer.makeMove(gameBoard);
            validMove = gameBoard.placeMove(positions[0], positions[1], playerSymbol); // validates player's movement

            if (!validMove) {
                gameUI.humanPlayerErrorMessage(HUMANPLAYER_MOVE_INVALID_EXCEPTION);
            }
        }
    }

    private void computerPlayerMove(char playerSymbol) {

        int[] positions = computerPlayer.makeMove(gameBoard);

        if (!gameBoard.placeMove(positions[0], positions[1], playerSymbol)) {
            gameUI.computerPlayerErrorMessage();
        }
    }
}