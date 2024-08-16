package players;

import board.GameBoard;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ComputerPlayer implements Player {

    private Random rand = new Random(); // Unique seed of the game for the difficulties.
    private final char symbol;
    private final String difficulty;

    public ComputerPlayer(final char symbol, final String difficulty) {
        this.difficulty = difficulty;
        this.symbol = symbol;
    }

    /**
     * This method allows the movements in the board, by the computer in this case.
     */
    @Override
    public int[] makeMove(GameBoard board) {
        switch (difficulty) {
            case "f":
                return easyDifficulty(board);
            case "m":
                return mediumDifficulty(board);
            case "d":
                return hardDifficulty(board);
            default:
                System.out.println("Dificultad invalida.");
                return new int[]{-1, -1};
        }
    }

    /**
     * This method allows the computer to determine a cell it myth put
     * its movement using a random value.
     */
    public int[] easyDifficulty(GameBoard board) {

        final List<int[]> availableMoves = new ArrayList<>();

        for (int row = 0; row < GameBoard.MAX_ROW; row++) {
            for (int col = 0; col < GameBoard.MAX_ROW; col++) {
                if (board.verifyBoardSquareIsEmpty(row, col)) {
                    availableMoves.add(new int[]{row, col});
                }
            }
        }

        return availableMoves.get(rand.nextInt(availableMoves.size()));
    }

    /**
     * This method allows the computer to determine a cell it myth put
     * its movement
     * **********************Falta explicacion ********************
     */
    public int[] mediumDifficulty(GameBoard board) {

        // Checks if it can win or block the opponent

        for (int row = 0; row < GameBoard.MAX_ROW; row++) {
            for (int col = 0; col < GameBoard.MAX_ROW; col++) {

                if (board.verifyBoardSquareIsEmpty(row, col)) {

                    board.placeMove(row, col, symbol);

                    if (board.checkGameWin(symbol)) {
                        return new int[]{row, col};
                    } else {
                        board.placeMove(row, col, ' ');
                    }
                }
            }
        }


        return easyDifficulty(board);
    }

    /**
     * This method allows the computer to determine a cell it myth put
     * its movement
     * **********************Falta explicacion ********************
     */
    public int[] hardDifficulty(GameBoard board) {
        // Yet to be implemented
        return null;
    }

    private int minimax(GameBoard board, int depth, boolean isMaximizing) {
        // Yet to be implemented
        return depth;
    }
}
