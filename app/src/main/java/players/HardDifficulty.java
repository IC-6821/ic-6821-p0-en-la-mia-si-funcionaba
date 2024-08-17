package players;

import board.GameBoard;

public class HardDifficulty implements Difficulty{
    @Override
    public int[] makeMove(GameBoard board) {
        return new int[0];
    }
}
