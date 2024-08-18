package gameuserinterface;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TerminalUI implements UI {

    private final Scanner scanner;
    private Map<String, Integer> positions = new HashMap<>();

    private final int firstCell = 0;
    private final int secondCell = 1;
    private final int thirdCell = 2;
    private final int fourthCell = 3;
    private final int fifthCell = 4;
    private final int sixthCell = 5;
    private final int seventhCell = 6;
    private final int eigthCell = 7;
    private final int ninthCell = 8;


    private static final String POS_ROW_TOP = "arriba";
    private static final String POS_ROW_MIDDLE = "medio";
    private static final String POS_ROW_BOTTOM = "abajo";
    private static final String POS_COL_LEFT = "izquierda";
    private static final String POS_COL_CENTER = "centro";
    private static final String POS_COL_RIGHT = "derecha";

    private static final int ERROR_POSITION_OCCUPIED = 002;
    private static final int ERROR_INVALID_POSITION = 003;

    public TerminalUI() {
        this.scanner = new Scanner(System.in);

        // We add the positions with their respective value.

        this.positions = Map.of(
                POS_ROW_TOP, 0,
                POS_ROW_MIDDLE, 1,
                POS_ROW_BOTTOM, 2,
                POS_COL_LEFT, 0,
                POS_COL_CENTER, 1,
                POS_COL_RIGHT, 2
        );
    }

    /**
     * This method prints a message in case a user wins.
     */
    @Override
    public void displayWinMessage() {
        System.out.println("Has ganado!");
    }

    /**
     * This method prints a message in case a user lose.
     */
    @Override
    public void displayLoseMessage() {
        System.out.println("Has perdido!");
    }

    /**
     * This method prints a message in case of Tie.
     */
    @Override
    public void displayTieMessage() {
        System.out.println("Ha sido un empate!");
    }

    /**
     * This method is used to read a user input.
     */
    @Override
    public String[] readHumanPlayerInput() {
        final String input = scanner.nextLine().toLowerCase();
        final String[] parts = input.split(" ");
        return parts;
    }

    /**
     * This method prints the exception in a message through console.
     */
    @Override
    public void humanPlayerErrorMessage(int exception) {
        switch (exception) {
            case ERROR_INVALID_POSITION:
                System.out.println("Por favor ingrese un movimiento válido");
                break;
            case ERROR_POSITION_OCCUPIED:
                System.out.println("La posicion ya esta ocupada. Intente otro movimiento");
                break;
            default:
                System.out.println("UNKNOWN ERROR, CHECK FOR DETAILS IN CONSOLE");
        }
    }

    /**
     * This method *****************
     */
    @Override
    public void computerPlayerErrorMessage() {
        System.out.println("Error, movimiento de maquina invalido");
    }

    /**
     * This method *****************
     */
    @Override
    public void gameConfigErrorMessage() {

    }

    /**
     * This method is responsible to show the status of the board,
     * in this case for a Terminal.
     */
    @Override
    public void showGame(String boardCellsToString) {

        final String[] boardStatusAux = boardCellsToString.split("");
        System.out.print(" " + boardStatusAux[firstCell] + " | ");
        System.out.print(boardStatusAux[secondCell] + " | ");
        System.out.print(boardStatusAux[thirdCell]);
        System.out.print("\n-----------\n");
        System.out.print(" " + boardStatusAux[fourthCell] + " | ");
        System.out.print(boardStatusAux[fifthCell] + " | ");
        System.out.print(boardStatusAux[sixthCell]);
        System.out.print("\n-----------\n");
        System.out.print(" " + boardStatusAux[seventhCell] + " | ");
        System.out.print(boardStatusAux[eigthCell] + " | ");
        System.out.print(boardStatusAux[ninthCell]);
        System.out.print("\n");
    }
}
