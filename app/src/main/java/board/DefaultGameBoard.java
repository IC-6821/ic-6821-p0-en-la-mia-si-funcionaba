package board;

public class DefaultGameBoard implements GameBoard {

    private char[][] gameBoard;
    private final int maxRow;
    private final int maxColumn;

    public DefaultGameBoard(final int maxRow, final int maxColumn) {
        this.maxRow = maxRow;
        this.maxColumn = maxColumn;
        gameBoard = new char[maxRow][maxColumn];
        placeSpacesInGameBoard();
    }

    private void placeSpacesInGameBoard() {
        for (int row = 0; row < maxRow; row++) {
            for (int column = 0; column < maxColumn; column++) {
                gameBoard[row][column] = ' ';
            }
        }
    }

    /**
     * This method checks for a position in the board, using integer values for
     * row and column it returns true if the position determined by these values
     * is empty and false in other case
     */
    public boolean verifyBoardSquareIsEmpty(int row, int column) {
        return gameBoard[row][column] == ' ';
    }

    private boolean checkRowWin(char playerPiece) {
        for (int row = 0; row < maxRow; row++) {
            boolean rowWin = true;
            for (int column = 0; column < maxColumn; column++) {
                if (gameBoard[row][column] != playerPiece) {
                    rowWin = false;
                    break;
                }
            }
            if (rowWin) {
                return true;
            }
        }
        return false;
    }

    private boolean checkColumnWin(char playerPiece) {
        for (int column = 0; column < maxColumn; column++) {
            boolean columnWin = true;
            for (int row = 0; row < maxRow; row++) {
                if (gameBoard[row][column] != playerPiece) {
                    columnWin = false;
                    break;
                }
            }
            if (columnWin) {
                return true;
            }
        }
        return false;
    }

    private boolean checkMainDiagonalWin(char playerPiece) {
        for (int rowAndColumn = 0; rowAndColumn < maxRow; rowAndColumn++) {
            if (gameBoard[rowAndColumn][rowAndColumn] != playerPiece) {
                return false;
            }
        }
        return true;
    }

    private boolean checkSecondDiagonalWin(char playerPiece) {
        for (int row = 0; row < maxRow; row++) {
            if (gameBoard[row][(maxColumn - 1) - row] != playerPiece) {
                return false;
            }
        }
        return true;
    }

    private boolean checkDiagonalWin(char playerPiece) {
        return (checkMainDiagonalWin(playerPiece)) || (checkSecondDiagonalWin(playerPiece));
    }

    /**
     * This method is used to check if a player got a row to win.
     */
    public boolean checkGameWin(char playerPiece) {
        return checkDiagonalWin(playerPiece) || checkColumnWin(playerPiece) || checkRowWin(playerPiece);
    }

    /**
     * This method is used to check if the game results in a tie
     */
    public boolean checkTie() {
         for (int row = 0; row < maxRow; row++) {
             for (int column = 0; column < maxRow; column++) {
                 if (gameBoard[row][column] == ' ') {
                    return false;
                 }
             }
         }
         return true;
    }

    /**
     * This method converts the board cells into a string that can be read.
     */
    public String boardCellsToString() {
        String boardChars = "";
        for (int row = 0; row < maxRow; row++) {
            for (int column = 0; column < maxColumn; column++) {
                boardChars = boardChars.concat(String.valueOf(gameBoard[row][column]));
            }
        }
        return boardChars;
    }
    /**
     * This method returns the char value of a specific cell
     */
    public char cellValue(int row, int column) {
        return gameBoard[row][column];
    }

    /**
     * This method is used to place a symbol inside the GameBoard,
     * depending on its position.
     */
    public boolean placeMove(int row, int col, char symbol) {
        if (verifyBoardSquareIsEmpty(row, col)) {
            gameBoard[row][col] = symbol;
            return true;

        }

        return false;

    }
    
}
