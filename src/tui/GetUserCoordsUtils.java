package tui;

import java.util.Scanner;

/**
 * This class gets the coordinates which were entered by the user.
 * Row and column are the one coordinates which can be retrieved. 
 * Two while loops are defined, one for the row and one for the column. 
 * Both loops print out the according column/row
 *
 * @author bonezf@usi.ch, carlo.pederiva@usi.ch 
 * @version 0.2
 */

public class GetUserCoordsUtils {
    
    private GetUserCoordsUtils() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }
    
    /**
     * Method getUserCoords is used to get the coordinates that the player wants to hit
     * in the gameBoard.
     *
     * @param gameBoardLength is the length of the gameBoard.
     * @return The return value is an array of integers, which composes rows and 
     *         columns of the gameBoard.
     */
    public static int[] getUserCoords(int gameBoardLength) {
        int row;
        int col;
        do {
            System.out.print("Row: ");
            row = new Scanner(System.in).nextInt();
        } 
        while (row < 0 || row >= gameBoardLength);
        do {
            System.out.print("Column: ");
            col = new Scanner(System.in).nextInt();
        } 
        while (col < 0 || col >= gameBoardLength);
        return new int[] {row, col};
    }
}