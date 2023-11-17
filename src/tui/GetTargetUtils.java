package tui;


/**
 * This class gets the target. 
 * It compares if the row/colum which make up a coordinate together
 * either hit a ship, the water or is out of range(or already hit).
 * The accoring message Hit, Miss, Already hit or out of range is then printed out accordingly.
 * Eventually the target will be returned.
 * 
 * @author bonezf@usi.ch, carlo.pederiva@usi.ch 
 * @version 0.3
 */

public class GetTargetUtils {
    
    private GetTargetUtils() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }
    
    /**
     * Method getTarget which checks if the target which was set was a Miss, Has 
     * already been atacked, a type of a certain ship has been destroyed, or if 
     * the postion in which the "bomb" was launched is a ship and it must be 
     * further attacked.
     *
     * @param guessCoords an int.
     * @param gameBoard Coordinates.
     * @return The return value in form of a String printing the accordin message 
     *         due to which position was attacked.
     */
    public static String getTarget(int[] guessCoords, model.Coordinates[][] gameBoard) {
        int row = guessCoords[0];
        int col = guessCoords[1];
        model.Coordinates target = gameBoard[row][col];
        target.uncover();
        if (target.getShips() == null) {
            return "Miss"; // as equal to water
        } else if (target.getShips().hasBeenAttacked(guessCoords)) {
            return "Has already been attacked";
        } else {
            target.getShips().attackPosition(guessCoords);
            if (target.getShips().isBoatDestroyed()) {
                return "The ship of type " + target.getShips().getName() + " has been destroyed";
            } else {
                return "This position must be attacked";
            }
        }
    }
}
