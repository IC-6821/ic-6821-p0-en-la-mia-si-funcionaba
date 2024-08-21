package players;

import java.util.HashMap;
import java.util.Map;

import board.GameBoard;
import gameuserinterface.UI;

public class HumanPlayer implements Player {
    private enum BoardRow {
        TOP,
        MIDDLE,
        BOTTOM
    }
    private enum BoardCol {
        LEFT,
        CENTER,
        RIGHT
    }

    private final UI gameUI;
    private Map<String, Integer> rowPositions = new HashMap<>();
    private Map<String, Integer> colPositions = new HashMap<>();
    private boolean validMove;

    private static final String POS_ROW_TOP = "arriba";
    private static final String POS_ROW_MIDDLE = "medio";
    private static final String POS_ROW_BOTTOM = "abajo";
    private static final String POS_COL_LEFT = "izquierda";
    private static final String POS_COL_CENTER = "centro";
    private static final String POS_COL_RIGHT = "derecha";

    private static final int ERROR_POSITION_OCCUPIED = 002;
    private static final int ERROR_INVALID_POSITION = 003;

    public HumanPlayer(final UI gameUI) {
        this.gameUI = gameUI;

        this.rowPositions = Map.of(
                POS_ROW_TOP, BoardRow.TOP.ordinal(),
                POS_ROW_MIDDLE, BoardRow.MIDDLE.ordinal(),
                POS_ROW_BOTTOM, BoardRow.BOTTOM.ordinal()
        );

        this.colPositions = Map.of(
                POS_COL_LEFT, BoardCol.LEFT.ordinal(),
                POS_COL_CENTER, BoardCol.CENTER.ordinal(),
                POS_COL_RIGHT, BoardCol.RIGHT.ordinal()
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
            final String[] parts = gameUI.readHumanPlayerInput();

            if (parts.length == 2) {
                row = rowPositions.getOrDefault(parts[0], -1);
                col = colPositions.getOrDefault(parts[1], -1);

                if (row != -1 && col != -1) {
                    if (board.verifyBoardSquareIsEmpty(row, col)) {
                        validMove = true;
                    } else {
                        gameUI.humanPlayerErrorMessage(ERROR_POSITION_OCCUPIED);
                    }
                } else {
                    gameUI.humanPlayerErrorMessage(ERROR_INVALID_POSITION);
                }
            } else {
                gameUI.humanPlayerErrorMessage(ERROR_INVALID_POSITION);
            }
        }
        return new int[]{row, col};
    }
}
