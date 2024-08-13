package gameLogic;

import board.GameBoard;
import players.ComputerPlayer;
import players.HumanPlayer;
import players.Player;
import gameUserInterface.TerminalDesign;

public class Game {

    // The game is going to use 4 objects, so we declare them inside the main Game class

    private TerminalDesign terminalDesign;
    private GameBoard gameBoard;
    private Player humanPlayer;
    private Player computerPlayer;

    public Game(String difficulty) { // Parametered constructor

        this.terminalDesign = new TerminalDesign();
        this.gameBoard = new GameBoard();
        this.humanPlayer = new HumanPlayer('X');
        this.computerPlayer = new ComputerPlayer('O', difficulty); // Difficulty was given by user input in the main function "String[] args"

    }

    public void Play() { // Function that dictates the flow of the game

        int turn = 0; // Using this as a flag to distiguish between User and computer so we don´t need to access any constants inside the player's class.
        char playerSymbol;

        while(turn < 9){    // QUERIDO PROFE, ESTO ES CÓDIGO ESPAGUETTI, PERO HONESTAMENTE ESTAMOS TOSTADOS COMO PARA MODULARIZARLO, PROMETEMOS HACERLO
                            // PARA LA ENTREGA FINAL, ATTE: EQUIPO DE REVISIÓN :)

                            // PDD: APRENDIMOS LA LECCIÓN, HAY QUE PLANEAR BIEN AL INICIO...

            if(turn % 2 == 0){

                playerSymbol = 'X';
                terminalDesign.showGame(gameBoard.BoardCellsToString()); // Show the current board to the user
                int[] positions = humanPlayer.MakeMove(gameBoard);

                if(gameBoard.placeMove(positions[0], positions[1], playerSymbol)){
                    turn++;
                    if(gameBoard.CheckGameWin(playerSymbol)){

                        System.out.println("Has ganado!");
                        break;
                    }
                    continue;
                }

                System.out.println("Por favor ingrese un movimiento válido");

            }else{

                playerSymbol = 'O';
                int[] positions = computerPlayer.MakeMove(gameBoard); //NECESARIO PASAR ESPACIOS LIBRES POR MEDIO DEL TABLERO

                if(gameBoard.placeMove(positions[0], positions[1], playerSymbol)){
                    turn++;
                    if(gameBoard.CheckGameWin(playerSymbol)){
                        System.out.println("Has perdido!");
                        break;
                    }
                }else{
                    System.out.println("LA CAGAMOS, ESTO NO DEBERÍA DAR ERROR - MOVIMIENTO DE MÁQUINA");
                }
            }
        }
        if(turn == 9){
            System.out.println("Ha sido un empate");
        }
    }

    private void HumanPlayerMove() {

    }

    private void ComputerPlayerMove() {

    }
}