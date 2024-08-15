package players;

import board.GameBoard;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ComputerPlayer implements Player {

    private Random rand = new Random(); // Unique seed of the game for the difficulties.
    private char symbol;
    private String difficulty;

    public ComputerPlayer(char symbol, String difficulty) {
        this.difficulty = difficulty;
        this.symbol = symbol;
    }

    @Override
    public int[] makeMove(GameBoard gameBoard) {
        switch (difficulty) {
            case "f":
                return easyDifficulty(gameBoard);
            case "m":
                return mediumDifficulty(gameBoard);
            case "d":
                return hardDifficulty(gameBoard);
            default:
                System.out.println("Dificultad invalida.");
                return new int[]{-1, -1};
        }
    }

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

    public int[] hardDifficulty(GameBoard board) {
        // Yet to be implemented
        return null;
    }

    private int minimax(GameBoard board, int depth, boolean isMaximizing) {
        // Yet to be implemented
        return depth;
    }
}
