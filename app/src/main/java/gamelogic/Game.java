package gamelogic;

import board.GameBoard;
import players.ComputerPlayer;
import players.HumanPlayer;
import players.Player;
import gameuserinterface.TerminalUI;
import gameuserinterface.UI;

public class Game {
    private static final int MAX_ROW = 3;
    private static final int MAX_COLUMN = 3;

    private final UI gameUI;
    private final GameBoard gameBoard;
    private Player humanPlayer;
    private Player computerPlayer;

    private final int humanPlayerInvalidMoveExpection = 001;
    private final int humanPlayerMoveOccupiedException = 002;
    private final int humanPlayerInputInvalidException = 003;

    private final int humanPlayerWinResult = 100;
    private final int computerPlayerWinResult = 101;
    private final int tieGameResult = 102;

    private boolean humanPlayerTurn = true;

    public Game(final String difficulty) {
        this.gameUI = new TerminalUI();
        this.gameBoard = new GameBoard(MAX_ROW, MAX_COLUMN);
        this.humanPlayer = new HumanPlayer('X');
        this.computerPlayer = new ComputerPlayer('O', difficulty);
        // function "String[] args"
    }

    /**
     * This method is responsible to keep the game running and control al the logic.
     */
    public void play() {

        int gameResult = 0;
        boolean activeGame = true;
        while (activeGame) {
            showGame();

            if (humanPlayerTurn) {
                humanPlayerMove('X');

            } else {
                computerPlayerMove('O');

            }

            gameResult = checkGameStatus();
            if (gameResult != 0) {
                activeGame = false;
            }

            humanPlayerTurn = !humanPlayerTurn;

        }

        switch (gameResult) {
            case humanPlayerWinResult:
                gameUI.displayWinMessage();
                break;
            case computerPlayerWinResult:
                gameUI.displayLoseMessage();
                break;
            case tieGameResult:
                gameUI.displayTieMessage();
                break;
            default:
                gameUI.gameConfigErrorMessage();
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

    private void showGame() {
        String boardChars = "";
        for (int row = 0; row < MAX_ROW; row++) {
            for (int column = 0; column < MAX_COLUMN; column++) {
                boardChars = boardChars.concat(String.valueOf(gameBoard.cellValue(row, column)));
            }
        }

        gameUI.showGame(boardChars);
    }

    private int checkGameStatus() {
        if (gameBoard.checkGameWin('X')) {
            return humanPlayerWinResult;

        } else if (gameBoard.checkGameWin('O')) {
            return computerPlayerWinResult;

        } else if (gameBoard.checkTie()) {
            return tieGameResult;

        } else {
            return 0;

        }
    }
}
