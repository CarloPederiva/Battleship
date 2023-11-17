package model;

/**
 * Write a description of class WarShip here.
 *
 * @author bonezf@usi.ch, carlo.pederiva@usi.ch 
 * @version 0.3
 */
public class AircraftCarrier extends BoatTypes {
    
    private String name;
    
    
    /**
     * AircraftCarrier Constructor.
     *
     * @param width is the width of the boat.
     * @param height is the height of the boat.
     */
    public AircraftCarrier(int width, int height) {
        super(width, height);
        
        this.name = "aircraftcarrier";
    }
    
    /**
     * Method getName is used to get the name of a BoatTypes.
     *
     * @return a String.
     */
    public String getName() {
        return name;
    }
}