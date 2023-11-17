package model;

import java.util.ArrayList;


/**
 * TotalShipDestroyed is a class that is needed to check is all boats have been destroyed.
 *
 * @author bonezf@usi.ch, carlo.pederiva@usi.ch 
 * @version 0.2
 */
public class TotalShipDestroyedUtils {
    
    
    /**
     * Method totalShipsDestroyed checks if all the boats that have been displayed on the gameBoard
     * (the array of DifferentBoats) have been destroyed.
     *
     * @param differentBoats is an array of all the boats in the game.
     * @return The return value is a boolean.
     */
    public static Boolean totalShipsDestroyed(ArrayList<BoatTypes> differentBoats) {
        for (BoatTypes boat : differentBoats) {
            if (!boat.isBoatDestroyed()) {
                return false;
            }
        }
        return true;
    }
}
