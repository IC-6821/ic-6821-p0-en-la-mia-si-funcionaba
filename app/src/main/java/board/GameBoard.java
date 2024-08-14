package board;

public class GameBoard {

    private char[][] gameBoard;
    public static final int DIMENSION = 3;

    public GameBoard() {
        gameBoard = new char[DIMENSION][DIMENSION];
        placeSpacesInGameBoard();
    }

    public void placeSpacesInGameBoard() {
        for (int row = 0; row < DIMENSION; row++) {
            for (int column = 0; column < DIMENSION; column++) {
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

    public boolean checkRowWin(char playerPiece) {
        for (int row = 0; row < DIMENSION; row++) {
            if (gameBoard[row][0] == playerPiece && gameBoard[row][1] == playerPiece && gameBoard[row][2] == playerPiece) {
                return true;
            }
        }
        return false;
    }

    public boolean checkColumnWin(char playerPiece) {
        for (int column = 0; column < DIMENSION; column++) {
            if (gameBoard[0][column] == playerPiece && gameBoard[1][column] == playerPiece && gameBoard[2][column] == playerPiece) {
                return true;
            }
        }
        return false;
    }

    public boolean checkMainDiagonalWin(char playerPiece) {
        for (int rowAndColumn = 0; rowAndColumn < DIMENSION; rowAndColumn++) {
            if (gameBoard[rowAndColumn][rowAndColumn] != playerPiece) {
                return false;
            }
        }
        return true;
    }

    public boolean checkSecondDiagonalWin(char playerPiece) {
        for (int row = 0; row < DIMENSION; row++) {
            if (gameBoard[row][(DIMENSION - 1) - row] != playerPiece) {
                return false;
            }
        }
        return true;
    }

    public boolean checkDiagonalWin(char playerPiece) {
        if ((checkMainDiagonalWin(playerPiece)) || (checkSecondDiagonalWin(playerPiece))) {
            return true;
        }
        return false;
    }

    public boolean CheckGameWin(char playerPiece) {
        if (checkDiagonalWin(playerPiece) || checkColumnWin(playerPiece) || checkRowWin(playerPiece)) {
            return true;
        }
        return false;
    }

//    public boolean CheckTie() { NO SE USA, PERO LA DEJAMOS EN CASO DE QUE EL PROFESOR DECIDA QUE ES ACERTADO QUE EL TAMAÑO Y OTRAS SEAN AJUSTABLES
//        for (int row = 0; row < DIMENSION; row++) {
//            for (int column = 0; column< DIMENSION; column++) {
//                if (gameBoard[row][column] == ' '){
//                    return false;
//                }
//            }
//        }
//        return true;
//    }

    public String boardCellsToString() {
        String boardChars = "";
        for (int row = 0; row < DIMENSION; row++) {
            for (int column = 0; column < DIMENSION; column++) {
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
}