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
    public int[] MakeMove(GameBoard gameBoard) {
        switch (difficulty) {
            case "f":
                return EasyDifficulty(gameBoard);
            case "m":
                return MediumDifficulty(gameBoard);
            case "d":
                return HardDifficulty(gameBoard);
            default:
                System.out.println("Dificultad invalida.");
                return new int[]{-1, -1};
        }
    }

    public int[] EasyDifficulty(GameBoard board) {
        
        List<int[]> availableMoves = new ArrayList<>();

        // Searches for empty spaces in the board
        
        for (int row = 0; row < GameBoard.DIMENSION; row++) {
            for (int col = 0; col < GameBoard.DIMENSION; col++) {
                if (board.VerifyBoardSquareIsEmpty(row, col)) {
                    availableMoves.add(new int[]{row, col});
                }
            }
        }

        return availableMoves.get(rand.nextInt(availableMoves.size())); // Returns a random movement from the available ones
    }

    public int[] MediumDifficulty(GameBoard board) {

        // Checks if it can win or block the opponent
        
        for (int row = 0; row < GameBoard.DIMENSION; row++) {
            for (int col = 0; col < GameBoard.DIMENSION; col++) {

                if (board.VerifyBoardSquareIsEmpty(row, col)) {
                    
                    board.placeMove(row, col, symbol);

                    if (board.CheckGameWin(symbol)) { // In case that specific movement wins, it returns that movement
                        return new int[]{row, col}; 
                    } else {
                        board.placeMove(row, col, ' '); // Else, it removes that movement
                    }
                }
            }
        }

        // If it couldn't win, places a random movement using EasyDifficulty

        return EasyDifficulty(board);
    }

    public int[] HardDifficulty(GameBoard board) {
        // Yet to be implemented
        return null;
    }

    private int minimax(GameBoard board, int depth, boolean isMaximizing) {
        // Yet to be implemented
        return depth;
    }
}