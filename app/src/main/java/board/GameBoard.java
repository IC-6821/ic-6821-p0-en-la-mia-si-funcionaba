package board;

public class GameBoard {

    private char[][] gameBoard;
    public static final int MAX_ROW = 3;
    public static final int MAX_COLUMN = 3;

    public GameBoard() {
        gameBoard = new char[MAX_ROW][MAX_COLUMN];
        placeSpacesInGameBoard();
    }

    private void placeSpacesInGameBoard() {
        for (int row = 0; row < MAX_ROW; row++) {
            for (int column = 0; column < MAX_COLUMN; column++) {
                gameBoard[row][column] = ' ';
            }
        }
    }

    public boolean verifyBoardSquareIsEmpty(int row, int column) {
        if (gameBoard[row][column] == ' ') {
            return true;
        }
        return false;
    }

    private boolean checkRowWin(char playerPiece) {
        for (int row = 0; row < MAX_ROW; row++) {
            if (gameBoard[row][0] == playerPiece && gameBoard[row][1] == playerPiece
                    && gameBoard[row][2] == playerPiece) {
                return true;
            }
        }
        return false;
    }

    private boolean checkColumnWin(char playerPiece) {
        for (int column = 0; column < MAX_COLUMN; column++) {
            if (gameBoard[0][column] == playerPiece && gameBoard[1][column] == playerPiece
                    && gameBoard[2][column] == playerPiece) {
                return true;
            }
        }
        return false;
    }

    private boolean checkMainDiagonalWin(char playerPiece) {
        for (int rowAndColumn = 0; rowAndColumn < MAX_ROW; rowAndColumn++) {
            if (gameBoard[rowAndColumn][rowAndColumn] != playerPiece) {
                return false;
            }
        }
        return true;
    }

    private boolean checkSecondDiagonalWin(char playerPiece) {
        for (int row = 0; row < MAX_ROW; row++) {
            if (gameBoard[row][(MAX_COLUMN - 1) - row] != playerPiece) {
                return false;
            }
        }
        return true;
    }

    private boolean checkDiagonalWin(char playerPiece) {
        if ((checkMainDiagonalWin(playerPiece)) || (checkSecondDiagonalWin(playerPiece))) {
            return true;
        }
        return false;
    }

    public boolean checkGameWin(char playerPiece) {
        if (checkDiagonalWin(playerPiece) || checkColumnWin(playerPiece) || checkRowWin(playerPiece)) {
            return true;
        }
        return false;
    }

//    public boolean CheckTie() {
//        for (int row = 0; row < MAX_ROW; row++) {
//            for (int column = 0; column< MAX_ROW; column++) {
//                if (gameBoard[row][column] == ' '){
//                    return false;
//                }
//            }
//        }
//        return true;
//    }

    public String boardCellsToString() {
        String boardChars = "";
        for (int row = 0; row < MAX_ROW; row++) {
            for (int column = 0; column < MAX_COLUMN; column++) {
                boardChars = boardChars.concat(String.valueOf(gameBoard[row][column]));
            }
        }
        return boardChars;
    }

    public boolean placeMove(int row, int col, char symbol) {
        if (verifyBoardSquareIsEmpty(row, col)) {

            gameBoard[row][col] = symbol;
            return true;
        }
        return false;
    }

    public int getMaxRow() {
        return MAX_ROW;
    }

    public int getMaxColumn() {
        return MAX_ROW;
    }
}
