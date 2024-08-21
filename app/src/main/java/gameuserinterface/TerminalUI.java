package gameuserinterface;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TerminalUI implements UI {

    private final Scanner scanner;
    private Map<String, Integer> positions = new HashMap<>();

    private final int maxRow;
    private final int maxColumn;


    private static final String POS_ROW_TOP = "arriba";
    private static final String POS_ROW_MIDDLE = "medio";
    private static final String POS_ROW_BOTTOM = "abajo";
    private static final String POS_COL_LEFT = "izquierda";
    private static final String POS_COL_CENTER = "centro";
    private static final String POS_COL_RIGHT = "derecha";

    private static final int ERROR_POSITION_OCCUPIED = 002;
    private static final int ERROR_INVALID_POSITION = 003;

    public TerminalUI(final int maxRow, final int maxColumn) {
        this.scanner = new Scanner(System.in);
        this.maxRow = maxRow;
        this.maxColumn = maxColumn;

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
        final int symbolFormatSpacer = 3;
        final int horizontalLine = (maxRow * symbolFormatSpacer) + (maxRow - 1);
        final String[] boardStatusAux = boardCellsToString.split("");

        System.out.print("\n");
        for (int i = 0; i < maxRow; i++) {
            for (int j = 0; j < maxColumn; j++) {
                if (j > 0) {
                    System.out.print("|");
                }

                final int stringToMatrixIndex = (i * maxRow) + j;
                System.out.print(" " + boardStatusAux[stringToMatrixIndex] + " ");
            }

            if (i < maxRow - 1) {
                System.out.print("\n" + "-".repeat(horizontalLine) + "\n");
            }

        }
        System.out.print("\n\n> ");

    }
}
