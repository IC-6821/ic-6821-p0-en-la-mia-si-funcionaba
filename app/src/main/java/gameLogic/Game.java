package gameLogic;

import board.GameBoard;
import players.ComputerPlayer;
import players.HumanPlayer;
import players.Player;
import gameUserInterface.TerminalDesign;

public class Game {

    // The game is going to use 4 objects, so we declare them inside the main Game
    // class

    private TerminalDesign terminalDesign;
    private GameBoard gameBoard;
    private Player humanPlayer;
    private Player computerPlayer;

    public Game(String difficulty) { // Parametered constructor

        this.terminalDesign = new TerminalDesign();
        this.gameBoard = new GameBoard();
        this.humanPlayer = new HumanPlayer('X');
        this.computerPlayer = new ComputerPlayer('O', difficulty); // Difficulty was given by user input in the main
                                                                   // function "String[] args"

    }

    public void Play() { // Function that dictates the flow of the game

        int turn = 0;

        while (turn < 9) {

            System.out.println("Turno numero:" + turn);
            terminalDesign.showGame(gameBoard.BoardCellsToString());

            switch (turn % 2) { // alternates between player and computer turns
                case 0:

                    HumanPlayerMove('X');
                    turn++;
                    if (gameBoard.CheckGameWin('X')) {
                        System.out.println("Has ganado!");
                        turn = 10; // When a victory is detected, ends the loop
                    }

                case 1:

                    ComputerPlayerMove('O');
                    turn++;
                    if (gameBoard.CheckGameWin('O')) {
                        System.out.println("Has perdido!");
                        turn = 10; // When a victory is detected, ends the loop
                    }
            }
        }
        if (turn == 9) { // If a victory is not registered, it's a tie
            System.out.println("Ha sido un empate");
        }
    }

    private void HumanPlayerMove(char playerSymbol) {
        
        boolean validMove = false;
        
        while (!validMove) {

            int[] positions = humanPlayer.MakeMove(gameBoard);
            validMove = gameBoard.placeMove(positions[0], positions[1], playerSymbol); // validates player's movement

            if (!validMove) {
                System.out.println("Por favor ingrese un movimiento válido");
            }
        }
    }

    private void ComputerPlayerMove(char playerSymbol) {

        int[] positions = computerPlayer.MakeMove(gameBoard);

        if (!gameBoard.placeMove(positions[0], positions[1], playerSymbol)) {
            System.out.println("Error, movimiento de maquina invalido");
        }
    }
}