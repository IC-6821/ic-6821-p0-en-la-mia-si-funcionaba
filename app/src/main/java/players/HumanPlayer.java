package players;

import board.GameBoard;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HumanPlayer implements Player {
    private char symbol;
    private final Scanner scanner;
    private final Map<String, Integer> positions = new HashMap<>();

    public HumanPlayer(char symbol) {
        this.symbol = symbol;

        this.scanner = new Scanner(System.in);
        // We add the positions with their respective value.
        this.positions.put("arriba", 0);
        this.positions.put("medio", 1);
        this.positions.put("abajo", 2);
        this.positions.put("izquierda", 0);
        this.positions.put("centro", 1);
        this.positions.put("derecha", 2);
    }

    @Override
    public void makeMove(GameBoard board) {
        int row = -1;
        int col = -1;

        while (true) {
            String input = scanner.nextLine().toLowerCase();
            String[] parts = input.split(" ");
            
            if (parts.length == 2) {
                row = positions.getOrDefault(parts[0], -1);
                col = positions.getOrDefault(parts[1], -1);
                
                if (row != -1 && col != -1 && board.VerifyBoardSquareIsEmpty(row, col)) {
                    board.placeMove(row, col, symbol);
                    return ;
                }
            }
        }
    }

    @Override
    public char getSymbol() {
        return symbol;
    }

}
