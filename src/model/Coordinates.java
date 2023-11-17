package model;


/**
 * Coordinates class is needed in the model to manage the coordinates of the
 * boats on the gameboard.
 *
 * @author bonezf@usi.ch, carlo.pederiva@usi.ch 
 * @version 0.1
 */
public class Coordinates
{
    
    private BoatTypes ships;
    private Boolean isUncoverd;

    /**
     * Constructor for objects of class Coordinates.
     */
    public Coordinates() {
        ships = null;
        isUncoverd = false;
    }
    
    /**
     * Method getIsUncoverd is needed to see if the boat is still uncoverd.
     *
     * @return a boolean.
     */
    public Boolean getIsUncoverd() {
        return isUncoverd;
    }
    
    /**
     * Method uncover set the previous return type, isUncovered, to true,
     * meaning the boat is now covered.
     *
     */
    public void uncover() {
        isUncoverd = true;
    }
    
    /**
     * Method setWarShip sets all the ships ready.
     *
     * @param game is of type BoatTypes in this case.
     */
    public void setShips(BoatTypes game) {
        ships = game;
    }
    
    /**
     * Method getWarShip  is needed to see the ships in the game.
     *
     * @return a BoatTypes.
     */
    public BoatTypes getShips() {
        return ships;
    }
    
    /**
     * Method copy is needed to to copy the coordinates on which the ships are
     * placed.
     *
     * @return an array of integers.
     */
    public Coordinates copy() {
        Coordinates coordsCopy = new Coordinates();
        if (ships != null) {
            coordsCopy.setShips(ships);
        }
        if (isUncoverd) {
            coordsCopy.uncover();
        }
        return coordsCopy;
    }
}