package players;

import board.GameBoard;
import gamedifficulties.Difficulty;
import gamedifficulties.EasyDifficulty;
import gamedifficulties.HardDifficulty;
import gamedifficulties.MediumDifficulty;

public class ComputerPlayer implements Player {
    private final Difficulty difficulty;
    private final char symbol;
    private final int maxRow;
    private final int maxColumn;

    public ComputerPlayer(final char symbol, final String difficultyLevel, final int maxRow, final int maxColumn) {
        this.symbol = symbol;
        this.maxRow = maxRow;
        this.maxColumn = maxColumn;

        switch (difficultyLevel) {
            case "f":
                this.difficulty = new EasyDifficulty(maxRow, maxColumn);
                break;
            case "m":
                this.difficulty = new MediumDifficulty(maxRow, maxColumn);
                break;
            case "d":
                this.difficulty = new HardDifficulty(maxRow, maxColumn);
                break;
            default:
                throw new IllegalArgumentException("Dificultad inválida: " + difficultyLevel);
        }

    }

    /**
     * This method is responsible for calling the chosen difficulty to make the move
     */
    @Override
    public int[] makeMove(GameBoard gameBoard) {

        return difficulty.makeMove(gameBoard);

    }
}
