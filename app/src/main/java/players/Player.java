package players;

import board.GameBoard;

public interface Player {
    void makeMove(GameBoard board);
    char getSymbol();
}