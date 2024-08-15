package players;

import board.GameBoard;

public interface Player {
    int[] makeMove(GameBoard gameBoard);
}
