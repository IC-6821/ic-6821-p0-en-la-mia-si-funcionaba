package Players;

import Board.GameBoard;

import java.util.Scanner;

public class HumanPlayer implements Player {
    private char symbol;

    public HumanPlayer(char symbol) {
        this.symbol = symbol;
    }

    @Override
    public void makeMove(GameBoard board) {
        Scanner scanner = new Scanner(System.in);
        int row = -1;
        int col = -1;
        boolean validMove = false;

        while (!validMove) {
            System.out.println("Ingrese su movimiento (fila columna): ");
            String input = scanner.nextLine();
            String[] parts = input.split(" ");
            
            if (parts.length == 2) {
                row = convertToRow(parts[0]);
                col = convertToColumn(parts[1]);
                
                if (row != -1 && col != -1 && board.VerifyBoardSquareIsEmpty(row, col)) {
                    board.placeMove(row, col, symbol);
                    validMove = true;
                } else {
                    System.out.println("Movimiento inválido. Inténtelo de nuevo");
                }
            } else {
                System.out.println("Entrada no válida. Use el formato: fila columna");
            }
        }
    }

    @Override
    public char getSymbol() {
        return symbol;
    }

    private int convertToRow(String row) {
        switch (row.toLowerCase()) {
            case "arriba":
                return 0;
            case "medio":
                return 1;
            case "abajo":
                return 2;
            default:
                return -1;
        }
    }

    private int convertToColumn(String col) {
        switch (col.toLowerCase()) {
            case "izquierda":
                return 0;
            case "centro":
                return 1;
            case "derecha":
                return 2;
            default:
                return -1;
        }
    }
}
