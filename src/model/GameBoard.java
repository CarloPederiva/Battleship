package model;

import java.util.ArrayList;

/**
 * This class is the gameBoard of the game. It determines the rows and colums of the gameBoard
 * with chars. It fills the rows of the array accoringly with wather or a ship.
 * 
 *
 * @author bonezf@usi.ch, carlo.pederiva@usi.ch 
 * @version 0.2
 */
public class GameBoard {
    
    private int gameBoardLength;
    private ArrayList<BoatTypes> differentBoats;
    
    /**
     * GameBoard Constructor.
     *
     * @param gameBoardLength indicates the length of the gameBoard.
     * @param differentBoats is an array of all the boats in the game.
     */
    public GameBoard(int gameBoardLength, ArrayList<BoatTypes> differentBoats) {
        this.gameBoardLength = gameBoardLength;
        this.differentBoats = differentBoats;
    }
    
    /**
     * Method createGameBoard creates the gameBoard.
     *
     * @return The return value is the gameBoard with the ships created on it.
     */
    public Coordinates[][] createGameBoard() {
        Coordinates[][] gameBoard = new Coordinates[gameBoardLength][gameBoardLength];
        PlaceShips placeShips = new PlaceShips(gameBoard);
        for (int i = 0; i < gameBoardLength; i++) {
            for (int j = 0; j < gameBoardLength; j++) {
                gameBoard[i][j] = new Coordinates();
            }
        }
        return placeShips.createPlaceShips(differentBoats);
    }
}
