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

        // Busca los espacios libres en el tablero
        for (int row = 0; row < GameBoard.DIMENSION; row++) {
            for (int col = 0; col < GameBoard.DIMENSION; col++) {
                if (board.VerifyBoardSquareIsEmpty(row, col)) {
                    availableMoves.add(new int[]{row, col});
                }
            }
        }

        // Selecciona un movimiento aleatorio
        return availableMoves.get(rand.nextInt(availableMoves.size()));
    }

    public int[] MediumDifficulty(GameBoard board) {
        // Busca si puede ganar o bloquear al oponente
        for (int row = 0; row < GameBoard.DIMENSION; row++) {
            for (int col = 0; col < GameBoard.DIMENSION; col++) {
                if (board.VerifyBoardSquareIsEmpty(row, col)) {
                    // Intenta colocar la pieza en la posición
                    board.placeMove(row, col, symbol);
                    if (board.CheckGameWin(symbol)) {
                        return new int[]{row, col}; // Gana
                    } else {
                        board.placeMove(row, col, ' '); // Deshace el movimiento
                    }
                }
            }
        }

        // Si no puede ganar ni bloquear, realiza un movimiento aleatorio como en EasyDifficulty
        return EasyDifficulty(board);
    }

    public int[] HardDifficulty(GameBoard board) {
        //Falta por implementar la dificultad dificil

        return null;
    }

    private int minimax(GameBoard board, int depth, boolean isMaximizing) {
        //Falta por implementar

        return depth;
    }
}