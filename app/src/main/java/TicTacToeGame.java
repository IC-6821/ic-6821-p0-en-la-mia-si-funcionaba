public class TicTacToeGame {
    private GameBoard gameBoard;
    private GameDifficulty difficulty;

    public void TicTacToeGame(GameBoard gameBoard, GameDifficulty difficulty) {
        this.gameBoard = gameBoard;
        this.difficulty = difficulty;
    }

    public void computerMove(char playerPiece) {
        difficulty.makeMove(gameBoard, playerPiece);
    }
}
