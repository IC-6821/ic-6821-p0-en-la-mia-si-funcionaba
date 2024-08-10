public interface GameBoard {
    void PlaceSpacesInGameBoard();
    boolean VerifyBoardSquareIsEmpty (int ROW, int COLUMS );
    boolean CheckGameWIn(char PLAYER_PIECE);
    boolean CheckTie();
    boolean CheckGameOver();
}
