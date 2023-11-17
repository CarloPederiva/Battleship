package model;

import java.util.ArrayList;


/**
 * This class is to add the boats in form of an ArrayList. In total there are 
 * four different types of boats which are WatShip, LittleShip, AircraftCarrier
 * and HelperShip. 
 *
 * @author bonezf@usi.ch, carlo.pederiva@usi.ch 
 * @version 0.1
 */
public class BoatsUtils {
    
    
    public static ArrayList<BoatTypes> differentBoats = new ArrayList<BoatTypes>();
    private static BoatTypes warShip = new WarShip(1, 5);
    private static BoatTypes littleShip = new LittleShip(1, 1);
    private static BoatTypes aircraftCarrier = new AircraftCarrier(1, 6);
    private static BoatTypes helperShip = new HelperShip(1, 3);
    
    
    /**
     * Method addBoats adds the boats to the array of differentBoats.
     *
     */
    public static void addBoats() {
        differentBoats.clear();
        differentBoats.add(warShip);
        differentBoats.add(littleShip); 
        differentBoats.add(aircraftCarrier); 
        differentBoats.add(helperShip); 
    }
    
    /**
     * Method restoreBoats restore every boat inside the array differentBoats.
     *
     */
    public static void restoreBoats() {
        for  (BoatTypes boat : differentBoats) {
            boat.restore();
        }
    }
}