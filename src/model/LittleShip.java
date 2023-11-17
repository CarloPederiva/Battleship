package model;



/**
 * Write a description of class WarShip here.
 *
 * @author bonezf@usi.ch, carlo.pederiva@usi.ch 
 * @version 0.3
 */
public class LittleShip extends BoatTypes {
    
    private String name;
    
    /**
     * LittleShip Constructor.
     *
     * @param width is the width of the boat.
     * @param height is the height of the boat.
     */
    public LittleShip(int width, int height) {
        super(width, height);
        
        this.name = "littleship";
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
