package gamedifficulties;

import board.GameBoard;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EasyDifficulty implements Difficulty {
    private final int maxRow;
    private final int maxColumn;

    public EasyDifficulty(final int maxRow, final int maxColumn) {
        this.maxRow = maxRow;
        this.maxColumn = maxColumn;
    }

    /**
     * This method is responsible for making the move for the computer player
     */
    @Override
    public int[] makeMove(GameBoard board) {
        final Random rand = new Random();
        final List<int[]> availableMoves = new ArrayList<>();

        for (int row = 0; row < maxRow; row++) {
            for (int col = 0; col < maxColumn; col++) {
                if (board.verifyBoardSquareIsEmpty(row, col)) {
                    availableMoves.add(new int[]{row, col});
                }
            }
        }

        return availableMoves.get(rand.nextInt(availableMoves.size()));
    }
}
