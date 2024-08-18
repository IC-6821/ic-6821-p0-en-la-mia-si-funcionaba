package gamedifficulties;

import board.GameBoard;
import players.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EasyDifficulty implements Player {
    private final int maxRow;
    private final int maxColumn;

    public EasyDifficulty(int maxRow, int maxColumn) {
        this.maxRow = maxRow;
        this.maxColumn = maxColumn;
    }

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
