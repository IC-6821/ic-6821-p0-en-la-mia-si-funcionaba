package gameuserinterface;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TerminalUI implements UI {

    private final Scanner SCANNER;
    private Map<String, Integer> positions = new HashMap<>();

    public TerminalUI() {
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
    public void displayWinMessage() {
        System.out.println("Has ganado!");
    }

    @Override
    public void displayLoseMessage() {
        System.out.println("Has perdido!");
    }

    @Override
    public void displayTieMessage() {
        System.out.println("Ha sido un empate!");
    }

    @Override
    public String[] readHumanPlayerInput() {
        String input = SCANNER.nextLine().toLowerCase();
        String[] parts = input.split(" ");
        return parts;
    }

    @Override
    public void humanPlayerErrorMessage(int EXCEPTION) {
        switch (EXCEPTION){
            case 001:
                System.out.println("Por favor ingrese un movimiento válido");
                break;
            case 002:
                System.out.println("La posicion ya esta ocupada. Intente otro movimiento");
                break;
            case 003:
                System.out.println("Entrada invalida. Por favor use el formato 'fila columna' (ej: arriba izquierda)");
                break;
            default:
                System.out.println("UNKNOWN ERROR, CHECK FOR DETAILS IN CONSOLE");
        }

    }

    @Override
    public void computerPlayerErrorMessage() {
        System.out.println("Error, movimiento de maquina invalido");
    }

    @Override
    public void gameConfigErrorMessage() {

    }

    @Override
    public void showGame(String boardCellsToString) {

        if (boardCellsToString.isEmpty()) {
            boardCellsToString = "         ";
        }
        String[] boardStatusAux = boardCellsToString.split("");
        System.out.print(" " + boardStatusAux[0] + " | " + boardStatusAux[1] + " | " + boardStatusAux[2]);
        System.out.print("\n-----------\n");
        System.out.print(" " + boardStatusAux[3] + " | " + boardStatusAux[4] + " | " + boardStatusAux[5]);
        System.out.print("\n-----------\n");
        System.out.print(" " + boardStatusAux[6] + " | " + boardStatusAux[7] + " | " + boardStatusAux[8]);
        System.out.print("\n");
    }

}