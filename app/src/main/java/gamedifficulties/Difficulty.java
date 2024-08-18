package gamedifficulties;

import board.GameBoard;

public interface Difficulty {
    static final int MAX_ROW = 3;
    static final int MAX_COLUMN = 3;
    int[] makeMove(GameBoard board);

}
