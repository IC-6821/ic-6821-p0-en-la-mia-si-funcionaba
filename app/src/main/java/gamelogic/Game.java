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

    private final int humanPlayerInvalidMoveExpection = 001;
    private final int humanPlayerMoveOccupiedException = 002;
    private final int humanPlayerInputInvalidException = 003;

    public Game(String difficulty) {

        this.gameUI = new TerminalUI();
        this.gameBoard = new GameBoard();
        this.humanPlayer = new HumanPlayer('X');
        this.computerPlayer = new ComputerPlayer('O', difficulty); // Difficulty was given by user input in the main
        // function "String[] args"

    }

    public void play() {

        int turn = 0;

        while (turn < 9) {

            gameUI.showGame(gameBoard.boardCellsToString());

            switch (turn % 2) { // alternates between player and computer turns
                case 0:

                    humanPlayerMove('X');
                    turn++;
                    if (gameBoard.checkGameWin('X')) {
                        gameUI.showGame(gameBoard.boardCellsToString());
                        gameUI.displayWinMessage();
                        turn = 10;
                    }
                    break;

                case 1:

                    computerPlayerMove('O');
                    turn++;
                    if (gameBoard.checkGameWin('O')) {
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

            final int[] positions = humanPlayer.makeMove(gameBoard);
            validMove = gameBoard.placeMove(positions[0], positions[1], playerSymbol); // validates player's movement

            if (!validMove) {
                gameUI.humanPlayerErrorMessage(humanPlayerInvalidMoveExpection);
            }
        }
    }

    private void computerPlayerMove(char playerSymbol) {

        final int[] positions = computerPlayer.makeMove(gameBoard);

        if (!gameBoard.placeMove(positions[0], positions[1], playerSymbol)) {
            gameUI.computerPlayerErrorMessage();
        }
    }
}
