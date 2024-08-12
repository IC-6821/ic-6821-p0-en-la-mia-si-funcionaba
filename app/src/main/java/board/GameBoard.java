package board;

public interface GameBoard {
    void PlaceSpacesInGameBoard();
    boolean VerifyBoardSquareIsEmpty(int ROW, int COLUMS);
    void placeMove(int row, int col, char symbol); // Agregado
    boolean CheckGameWIn(char PLAYER_PIECE);
    boolean CheckTie();
    boolean CheckGameOver();
    String BoardStatus();
}
