package gamedifficulties;

import board.GameBoard;

public class MediumDifficulty implements Difficulty {
    private final int maxRow;
    private final int maxColumn;

    public MediumDifficulty(final int maxRow, final int maxColumn) {
        this.maxRow = maxRow;
        this.maxColumn = maxColumn;
    }

    /**
     * This method is responsible for making the move for the computer player
     */
    @Override
    public int[] makeMove(GameBoard board) {
        return new int[0];
    }
}
