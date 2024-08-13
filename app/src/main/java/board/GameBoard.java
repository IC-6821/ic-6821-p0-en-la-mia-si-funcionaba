package board;

public class GameBoard {
    private char[][] gameBoard;
    public static final int DIMENSION = 3;

    public GameBoard(){
        gameBoard = new char[DIMENSION][DIMENSION];
        PlaceSpacesInGameBoard();
    }
    
    public void PlaceSpacesInGameBoard() {
        for (int row = 0; row < DIMENSION; row++) {
            for (int column  = 0; column < DIMENSION; column++) {
                gameBoard[row][column] = ' ';
            }
        }
    }
    
    public boolean VerifyBoardSquareIsEmpty(int row, int column) {
        if(gameBoard[row][column] == ' ') {
            return true;
        }
        return false;
    }

    public boolean CheckRowWin(char playerPiece){
        for (int row = 0; row < DIMENSION; row++) {
            if (gameBoard[row][0] == playerPiece && gameBoard[row][1] == playerPiece && gameBoard[row][2] == playerPiece) {
                return true;
            }
        }
        return false;
    }

    public boolean CheckColumnWin (char playerPiece){
        for (int column= 0; column < DIMENSION; column++) {
            if (gameBoard[0][column] == playerPiece && gameBoard[1][column] == playerPiece && gameBoard[2][column] == playerPiece) {
                return true;
            }
        }
        return false;
    }

    public boolean CheckMainDiagonalWin (char playerPiece){
        for (int rowAndColumn = 0; rowAndColumn<DIMENSION; rowAndColumn++) {
           if (gameBoard[rowAndColumn][rowAndColumn] != playerPiece) {
               return false;
           }
        }
        return true;
    }

    public boolean CheckSecondDiagonalWin (char playerPiece){
        for (int row = 0; row<DIMENSION; row++) {
            if (gameBoard[row][(DIMENSION-1)-row] != playerPiece){
                return false;
            }
        }
        return true;
    }

    public boolean CheckDiagonalWin (char playerPiece){
        if ((CheckMainDiagonalWin(playerPiece)) || (CheckSecondDiagonalWin(playerPiece))) {
            return true;
        }
        return false;
    }

    
    public boolean CheckGameWin(char playerPiece) {
        if(CheckDiagonalWin(playerPiece) || CheckColumnWin(playerPiece) || CheckRowWin(playerPiece)){
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

    
    public String BoardCellsToString() {
        String boardChars="";
        for (int row = 0; row < DIMENSION; row++) {
            for (int column  = 0; column < DIMENSION; column++) {
                boardChars.concat(String.valueOf(gameBoard[row][column]));
            }
        }
        return boardChars;
    }

    
    public boolean placeMove(int row, int col, char symbol) { // Agregado
        if (VerifyBoardSquareIsEmpty(row, col)) {
            gameBoard[row][col] = symbol;
            return true;
        }
        return false;
    }
}