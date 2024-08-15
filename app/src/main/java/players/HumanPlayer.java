package players;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import board.GameBoard;

public class HumanPlayer implements Player {
    private final Scanner scanner;
    private Map<String, Integer> positions = new HashMap<>();
    private boolean validMove;

    public HumanPlayer(char symbol) {

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
    public int[] makeMove(GameBoard board) {
        int row = -1;
        int col = -1;
        validMove = false;

        while (!validMove) {
            final String input = scanner.nextLine().toLowerCase();
            final String[] parts = input.split(" ");

            if (parts.length == 2) {
                row = positions.getOrDefault(parts[0], -1);
                col = positions.getOrDefault(parts[1], -1);

                if (row >= 0 && row < GameBoard.MAX_ROW && col >= 0 && col < GameBoard.MAX_ROW) {
                    if (board.verifyBoardSquareIsEmpty(row, col)) {
                        validMove = true;
                    } else {
                        System.out.println("La posicion ya esta ocupada. Intente otro movimiento");
                        // HUMAN PLAYER
                    }
                } else {
                    System.out.println("Posicion invalida. Por favor ingrese una posicion valida");
                }
            } else {
                System.out.println("Entrada invalida. Por favor use el formato 'fila columna' (ej: arriba izquierda)");
            }
        }
        return new int[]{row, col};
    }
}
