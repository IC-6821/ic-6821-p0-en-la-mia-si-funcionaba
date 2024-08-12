package Players;

import Board.GameBoard;

public interface Player {
    void makeMove(GameBoard board);
    char getSymbol();
}
