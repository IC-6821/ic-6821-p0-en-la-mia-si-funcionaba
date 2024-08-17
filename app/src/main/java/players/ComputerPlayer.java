package players;

import board.GameBoard;

public class ComputerPlayer implements Player {

    private final char symbol;
    private final Difficulty difficulty;

    public ComputerPlayer(final char symbol, final String difficultyLevel) {
        this.symbol = symbol;

        switch (difficultyLevel) {
            case "f":
                this.difficulty = new EasyDifficulty();
                break;
            case "m":
                this.difficulty = new MediumDifficulty();
                break;
            case "d":
                this.difficulty = new HardDifficulty();
                break;
            default:
                throw new IllegalArgumentException("Dificultad inválida: " + difficultyLevel);
        }
    }

    @Override
    public int[] makeMove(GameBoard board) {

        return new int[0];
    }
}
