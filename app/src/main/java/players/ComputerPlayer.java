package players;

import board.GameBoard;
import gamedifficulties.EasyDifficulty;
import gamedifficulties.HardDifficulty;
import gamedifficulties.MediumDifficulty;

public class ComputerPlayer implements Player {
    private Player difficulty;
    private final char symbol;
    private final String difficultyLevel;
    private final int maxRow;
    private final int maxColumn;

    public ComputerPlayer(final char symbol, final String difficultyLevel, final int maxRow, final int maxColumn) {
        this.symbol = symbol;
        this.difficultyLevel = difficultyLevel;
        this.maxRow = maxRow;
        this.maxColumn = maxColumn;
    }

    @Override
    public int[] makeMove(GameBoard gameBoard) {
        Player difficulty;
        switch (difficultyLevel) {
            case "f":
                difficulty = new EasyDifficulty(maxRow, maxColumn);
                break;
            case "m":
                difficulty = new MediumDifficulty(maxRow, maxColumn);
                break;
            case "d":
                difficulty = new HardDifficulty(maxRow, maxColumn);
                break;
            default:
                throw new IllegalArgumentException("Dificultad inválida: " + difficultyLevel);
        }
        return difficulty.makeMove(gameBoard);
    }
}
