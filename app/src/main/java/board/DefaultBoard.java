package board;

public class DefaultBoard implements GameBoard {
    private char[][] gameBoard;
    public static final int DIMENSION = 3;

    public DefaultBoard(){
        gameBoard = new char[DIMENSION][DIMENSION];
        PlaceSpacesInGameBoard();
    }


    @Override
    public void PlaceSpacesInGameBoard() {
        for (int ROWS = 0; ROWS < DIMENSION; ROWS++) {
            for (int COLUMNS  = 0; COLUMNS < DIMENSION; COLUMNS++) {
                gameBoard[ROWS][COLUMNS] = ' ';
            }
        }
    }

    @Override
    public boolean VerifyBoardSquareIsEmpty(int ROW, int COLUMS) {
        if(gameBoard[ROW][COLUMS] == ' ') {
            return true;
        }
        return false;
    }

    public boolean CheckRowWin(char PLAYER_PIECE){
        for (int ROW= 0; ROW < DIMENSION; ROW++) {
            if (gameBoard[ROW][0] == PLAYER_PIECE && gameBoard[ROW][1] == PLAYER_PIECE && gameBoard[ROW][2] == PLAYER_PIECE) {
                return true;
            }
        }
        return false;
    }

    public boolean CheckColumnWin (char PLAYER_PIECE){
        for (int COLUMN= 0; COLUMN < DIMENSION; COLUMN++) {
            if (gameBoard[0][COLUMN] == PLAYER_PIECE && gameBoard[1][COLUMN] == PLAYER_PIECE && gameBoard[2][COLUMN] == PLAYER_PIECE) {
                return true;
            }
        }
        return false;
    }

    public boolean CheckMainDiagonalWin (char PLAYER_PIECE){
       for (int ROW_AND_COLUMN = 0; ROW_AND_COLUMN<DIMENSION; ROW_AND_COLUMN++) {
           if ( gameBoard[ROW_AND_COLUMN][ROW_AND_COLUMN] != PLAYER_PIECE || gameBoard[ROW_AND_COLUMN][ROW_AND_COLUMN] == ' ') {
               return false;
           }
       }
        return true;
    }

    public boolean CheckSecondDiagonalWin (char PLAYER_PIECE){
        for (int ROW = 0; ROW<DIMENSION; ROW++) {
            if ( gameBoard[ROW][DIMENSION-1-ROW] != PLAYER_PIECE || gameBoard[ROW][DIMENSION-1-ROW] == ' ') {
                return false;
            }
        }
        return true;
    }

    public boolean CheckDiagonalWin (char PLAYER_PIECE){
        if ((CheckMainDiagonalWin(PLAYER_PIECE)) || (CheckSecondDiagonalWin(PLAYER_PIECE))) {
            return true;
        }
        return false;
    }


    @Override
    public boolean CheckGameWIn(char PLAYER_PIECE) {
        if(CheckDiagonalWin(PLAYER_PIECE) || CheckColumnWin(PLAYER_PIECE) || CheckRowWin(PLAYER_PIECE)){
            return true;
        }
        return false;
    }


    public boolean CheckFreeSpaces(){
        for (int ROW = 0; ROW < DIMENSION; ROW++) {
            for (int COLUMN = 0; COLUMN< DIMENSION; COLUMN++) {
                if (gameBoard[ROW][COLUMN] == ' '){
                    return true;
                }
            }
        }
        return false;
    }
    @Override
    public boolean CheckTie() {
        if( !CheckFreeSpaces() && !CheckGameWIn('X') && !CheckGameWIn('O')){
            return true;
        }
        return false;
    }

    @Override
    public boolean CheckGameOver() {
        if(CheckTie()||  CheckGameWIn('X') || CheckGameWIn('O')){
            return true;
        }
        return false;
    }

    @Override
    public String BoardStatus() {
        String boardChars="";
        for (int ROWS = 0; ROWS < DIMENSION; ROWS++) {
            for (int COLUMNS  = 0; COLUMNS < DIMENSION; COLUMNS++) {
                boardChars.concat(String.valueOf(gameBoard[ROWS][COLUMNS]));
            }
        }
        return boardChars;
    }

    @Override
    public void placeMove(int row, int col, char symbol) { // Agregado
        if (VerifyBoardSquareIsEmpty(row, col)) {
            gameBoard[row][col] = symbol;
        }
    }

}
