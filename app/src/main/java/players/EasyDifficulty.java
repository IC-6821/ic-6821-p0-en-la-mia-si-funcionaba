package players;

import board.GameBoard;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EasyDifficulty implements Difficulty {
    @Override
    public int[] makeMove(GameBoard board) {
        final Random rand = new Random();
        final List<int[]> availableMoves = new ArrayList<>();

        for (int row = 0; row < GameBoard.MAX_ROW; row++) {
            for (int col = 0; col < GameBoard.MAX_COLUMN; col++) {
                if (board.verifyBoardSquareIsEmpty(row, col)) {
                    availableMoves.add(new int[]{row, col});
                }
            }
        }

        return availableMoves.get(rand.nextInt(availableMoves.size()));
    }
}

