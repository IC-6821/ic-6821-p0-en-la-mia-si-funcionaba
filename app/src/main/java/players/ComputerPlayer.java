package players;

import board.GameBoard;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ComputerPlayer implements Player {

    // Unique seed of the game for the difficulties.
    private Random rand = new Random();
    private char symbol;
    private String difficulty;

    public ComputerPlayer(char symbol, String difficulty) {
        this.difficulty = difficulty;
        this.symbol = symbol;
    }

    @Override
    public int[] MakeMove(GameBoard gameBoard) {

        int[] x = {2,1};

        switch (difficulty){
            case "f":
                return EasyDifficulty(gameBoard);
            case "m":
                return x;
            case "d":
                return x;
            default:
                System.out.println("TA MALA WEONAO");
                return x;
        }
    }

    public int[] EasyDifficulty(GameBoard board) {

        List<int[]> availableMoves = new ArrayList<>();

        // Search for the free spaces in the board.
        for (int row = 0; row < GameBoard.DIMENSION; row++) {
            for (int col = 0; col < GameBoard.DIMENSION; col++) {
                if (board.VerifyBoardSquareIsEmpty(row, col)) {
                    availableMoves.add(new int[]{row, col});
                }
            }
        }
        int[] moveCoordinates = availableMoves.get(rand.nextInt(availableMoves.size()));
        return moveCoordinates;
    }

//    public static class MediumDifficulty implements Player {
//        private char symbol;
//
//        public MediumDifficulty(char symbol) {
//            this.symbol = symbol;
//        }
//
//        @Override
//        public void makeMove(GameBoard board) {
//            if (!tryToWinOrBlock(board)) {
//                new EasyDifficulty(symbol).makeMove(board); // Si no puede ganar o bloquear, hace un movimiento fácil
//            }
//        }
//
//        private boolean tryToWinOrBlock(GameBoard board) {
//            for (int row = 0; row < GameBoard.DIMENSION; row++) {
//                for (int col = 0; col < GameBoard.DIMENSION; col++) {
//                    if (board.VerifyBoardSquareIsEmpty(row, col)) {
//                        board.placeMove(row, col, symbol);
//                        if (board.CheckGameWIn(symbol)) {
//                            return true;
//                        } else {
//                            board.placeMove(row, col, ' '); // Quita el movimiento
//                        }
//                    }
//                }
//            }
//            return false;
//        }
//
//        @Override
//        public char getSymbol() {
//            return symbol;
//        }
//    }
//
//    public static class HardDifficulty implements Player {
//        private char symbol;
//
//        public HardDifficulty(char symbol) {
//            this.symbol = symbol;
//        }
//
//        @Override
//        public void makeMove(GameBoard board) {
//            int bestRow = -1;
//            int bestCol = -1;
//            int bestScore = Integer.MIN_VALUE;
//
//            for (int row = 0; row < 3; row++) {
//                for (int col = 0; col < 3; col++) {
//                    if (board.VerifyBoardSquareIsEmpty(row, col)) {
//                        board.placeMove(row, col, symbol);
//                        int score = minimax(board, 0, false);
//                        board.placeMove(row, col, ' '); // Deshacer el movimiento
//
//                        if (score > bestScore) {
//                            bestScore = score;
//                            bestRow = row;
//                            bestCol = col;
//                        }
//                    }
//                }
//            }
//
//            board.placeMove(bestRow, bestCol, symbol);
//        }
//
//        private int minimax(GameBoard board, int depth, boolean isMaximizing) {
//            // Falta implementar
//            return 0;
//        }
//
//        @Override
//        public char getSymbol() {
//            return symbol;
//        }
//    }
}
