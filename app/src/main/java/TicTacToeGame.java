
public class TicTacToeGame {
    private GameBoard gameBoard;
    private Player humanPlayer;
    private Player computerPlayer;

    public TicTacToeGame(GameBoard gameBoard, Player humanPlayer) {
        this.gameBoard = gameBoard;
        this.humanPlayer = humanPlayer;
        DifficultyMenu menu = new DifficultyMenu();
        this.computerPlayer = menu.selectDifficulty();
    }

    public void play() {
        while (!gameBoard.CheckGameOver()) {
            humanPlayer.makeMove(gameBoard);
            if (gameBoard.CheckGameOver()) break;
            computerPlayer.makeMove(gameBoard);
        }

        // Mostrar resultados del juego (Falta implementar)
    }
}

