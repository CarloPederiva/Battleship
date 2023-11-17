package model;

import java.security.SecureRandom;
import java.util.ArrayList;

/**
 * GameAI is the class that controls the AI.
 *
 * @author bonezf@usi.ch, carlo.pederiva@usi.ch 
 * @version 0.1
 */
public class GameAI {
    private ArrayList<String> coordinatesPlayed;
    private int length;
    
    /**
     * GameAI Constructor.
     *
     * @param length is an int.
     */
    public GameAI(int length) {
        this.length = length;
        coordinatesPlayed = new ArrayList<String>();
    }
    
    /**
     * Method getCoords An accessor which return randomly generated coordinates for row
     * and column.
     *
     * @return coordinates for accessing and evaluating if the row col are valid.
     * 
     */
    public int[] getCoords() {
        SecureRandom  rand = new SecureRandom();
        int row;
        int col;
        do {
            row = rand.nextInt(length);
            col = rand.nextInt(length);
        } 
        while (!coordIsValid(row,col));
        coordinatesPlayed.add(row + "" + col);
        return new int[]{row,col};
    }
    
    /**
     * Method coordIsValid checks if the selected coordinates are valid and within the 
     * field.
     *
     * @param row A parameter of type int for passing in the coordinate of the row.
     * @param col A parameter of type int for passing in the coordinate of the column.
     * @return value of type boolean to check if the passes in row and colum are valid.
     * 
     */
    private boolean coordIsValid(int row, int col) {
        return !coordinatesPlayed.contains(row + "" + col);
    }
}
