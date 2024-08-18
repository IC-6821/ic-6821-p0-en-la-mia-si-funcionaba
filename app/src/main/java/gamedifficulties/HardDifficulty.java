package gamedifficulties;

import board.GameBoard;
import gamedifficulties.Difficulty;

public class HardDifficulty implements Difficulty {
    @Override
    public int[] makeMove(GameBoard board) {
        return new int[0];
    }
}
