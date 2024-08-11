import java.util.Random;

public class TypeOfDifficulties {
    public static class EasyDifficulty implements GameDifficulty {
        @Override
        //Realiza movimientos aleatorias
        public void makeMove(GameBoard board, char symbol) {
            Random rand = new Random();
            int row, colums;
            do {
                row = rand.nextInt(3);
                colums = rand.nextInt(3);
            } while (!board.VerifyBoardSquareIsEmpty(row, colums));
            board.placeMove(row, colums, symbol);
        }
    }

    public static class MediumDifficulty implements GameDifficulty {
        @Override
        public void makeMove(GameBoard board, char symbol) {
            // Intenta ganar o bloquear al oponente
            if (!tryToWinOrBlock(board, symbol)) {
                //Se implementa en caso de que no sepa que hacer y realice un movimiento aleatorio
            }
        }

        private boolean tryToWinOrBlock(GameBoard board, char symbol) {
            // Implementación para intentar ganar o bloquear al oponente
            return false;
        }
    }

    public static class HardDifficulty implements GameDifficulty {
        @Override
        public void makeMove(GameBoard board, char symbol) {
            //Se implementa despues
        }
    }
}
