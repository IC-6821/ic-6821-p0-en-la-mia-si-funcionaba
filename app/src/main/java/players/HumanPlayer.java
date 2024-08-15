package players;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import board.GameBoard;

public class HumanPlayer implements Player {
    private final Scanner SCANNER;
    private Map<String, Integer> positions = new HashMap<>();

    public HumanPlayer(char symbol) {

        this.SCANNER = new Scanner(System.in);

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

        while (true) {

            String input = SCANNER.nextLine().toLowerCase();
            String[] parts = input.split(" ");

            if (parts.length == 2) {
                row = positions.getOrDefault(parts[0], -1); // Searches for the input's horizontal coordinate equivalent inside the dictionary
                col = positions.getOrDefault(parts[1], -1); // Searches for the input's vertical coordinate equivalent inside the dictionary

                if (row >= 0 && row < GameBoard.DIMENSION && col >= 0 && col < GameBoard.DIMENSION) {
                    if (board.verifyBoardSquareIsEmpty(row, col)) {
                        return new int[]{row, col}; // Valid move
                    } else {
                        System.out.println("La posicion ya esta ocupada. Intente otro movimiento"); // ESTAS VERIFICACIONES DEBEN OCURRIR FUERA DE
                                                                                                    // HUMAN PLAYER
                    }
                } else {
                    System.out.println("Posicion invalida. Por favor ingrese una posicion valida");
                }
            } else {
                System.out.println("Entrada invalida. Por favor use el formato 'fila columna' (ej: arriba izquierda)");
            }
        }
    }
}