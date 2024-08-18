package players;

import board.GameBoard;
import gamedifficulties.EasyDifficulty;
import gamedifficulties.HardDifficulty;
import gamedifficulties.MediumDifficulty;

public class ComputerPlayer implements Player {
    private final Player difficulty;
    private final char symbol;

    public ComputerPlayer(final char symbol, final String difficultyLevel, final int maxRow, final int maxColumn) {
        this.symbol = symbol;

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

    @Override
    public int[] makeMove(GameBoard gameBoard) {
        return new int[0];
    }
}
