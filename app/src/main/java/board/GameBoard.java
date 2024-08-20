package board;

public interface GameBoard {
    boolean verifyBoardSquareIsEmpty(int row, int column);
    boolean checkGameWin(char playerPiece);
    boolean checkTie();
    String boardCellsToString();
    char cellValue(int row, int column);
    boolean placeMove(int row, int col, char symbol);

}
