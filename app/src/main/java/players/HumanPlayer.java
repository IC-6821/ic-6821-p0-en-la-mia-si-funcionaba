package players;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import board.GameBoard;
import gameuserinterface.TerminalUI;

public class HumanPlayer implements Player {
    private final Scanner scanner;
    private final TerminalUI ui;
    private Map<String, Integer> positions = new HashMap<>();
    private boolean validMove;

    private static final String POS_ROW_TOP = "arriba";
    private static final String POS_ROW_MIDDLE = "medio";
    private static final String POS_ROW_BOTTOM = "abajo";
    private static final String POS_COL_LEFT = "izquierda";
    private static final String POS_COL_CENTER = "centro";
    private static final String POS_COL_RIGHT = "derecha";

    private static final int ERROR_POSITION_OCCUPIED = 002;
    private static final int ERROR_INVALID_POSITION = 003;

    public HumanPlayer(final char symbol, TerminalUI ui) {
        this.ui = ui;

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
     * This method allows the movements in the board, by a user in this case.
     **/
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
                        ui.humanPlayerErrorMessage(ERROR_POSITION_OCCUPIED);
                    }
                } else {
                    ui.humanPlayerErrorMessage(ERROR_INVALID_POSITION);
                }
            } else {
                ui.humanPlayerErrorMessage(ERROR_INVALID_POSITION);
            }
        }
        return new int[]{row, col};
    }
}