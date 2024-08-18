package gamedifficulties;

import board.GameBoard;
import players.Player;

public class MediumDifficulty implements Player {
    private final int maxRow;
    private final int maxColumn;

    public MediumDifficulty(int maxRow, int maxColumn) {
        this.maxRow = maxRow;
        this.maxColumn = maxColumn;
    }

    @Override
    public int[] makeMove(GameBoard board) {
        return new int[0];
    }
}
