package players;

import board.GameBoard;

public interface Player {
    int[] MakeMove(GameBoard gameBoard);
}