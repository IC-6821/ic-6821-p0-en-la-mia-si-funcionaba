package gameDifficulties;

import java.util.Random;
public class EasyDifficulty implements GameDifficulty {

    @Override
    public void makeMoveIA(char[][] gameBoard, char playerPiece) {
        Random random = new Random();
        int row, colums;
        do {
            row = random.nextInt(3);
            colums = random.nextInt(3);
        } while (gameBoard[row][colums] != ' ');
        gameBoard[row][colums] = playerPiece;
    }
}
