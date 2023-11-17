package model;

import java.util.ArrayList;

/**
 * This is the general AllBoats class. Here the dimensions, boolean, accessors and status is defined. 
 * The other boat classes use this class in regard of polymarism to refer to it.
 *
 * @author bonezf@usi.ch, carlo.pederiva@usi.ch 
 * @version 0.4
 */

public class BoatTypes {
    public String name;
    private int width; 
    private int height;
    private int destroyedParts;
    private int boatDimension;
    private ArrayList<int[]> positionsDestroyed = new ArrayList<int[]>();
    
    /**
     * Constructor of the AllBoats class.
     * The width and height are associated and the boatDestroyed associated to a boolean.
     * @param width represent the width of a boat.
     * @param height represent the height of a boat.
     */
    public BoatTypes(int width, int height) {
        this.width = width;
        this.height = height;
        destroyedParts = 0;
        boatDimension = width * height;
    }   
    
    
    /**
     * Method copy just returns a new BoatTypes.
     *
     * @return A type of Boat.
     */
    public BoatTypes copy() {
        return new BoatTypes(width,height);
    }
    
    /**
     * Method getName is used to get the name of a BoatTypes.
     *
     * @return a String.
     */
    public String getName() {
        return name;
    }
    
    /**
     * Method hasBeenAttacked is used to detect if a boat has been attacked
     * until it is destroyed.
     *
     * @param pos is an array indicating the coordinates of a boat.
     * @return a boolean.
     */
    public boolean hasBeenAttacked(int[] pos) { 
        for (int[] itemPos: positionsDestroyed) {
            if (pos[0] == itemPos[0] && pos[1] == itemPos[1]) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Method restore makes the destroyed parts of a boat equals to zero, so
     * that the boat is "regenerated".
     *
     */
    public void restore() {
        destroyedParts = 0;
        positionsDestroyed.clear();
    }
    
    /**
     * Method attackPosition adds up the parts of the boat that have been hit.
     *
     * @param pos is an array indicating the coordinates of a boat.
     */
    public void attackPosition(int[] pos) { 
        int[] cords = new int[3];
        cords[0] = pos[0];
        cords[1] = pos[1];
        positionsDestroyed.add(pos);
        destroyedParts++;
    }
    
    /**
     * Method getBoatDimension is used to get the dimensions of a boat.
     *
     * @return dimensions of a boat.
     */
    public int getBoatDimension() {
        return width * height;
    }
    
    /**
     * Method setIsBoatDestroyed is used to set a boat as destroyed.
     *
     */
    public void setIsBoatDestroyed() {
        destroyedParts = boatDimension;
    }
    
    /**
     * Method getIsBoatDestroyed is used to see if a boat is destroyed.
     *
     * @return boolean true or false.
     */
    public boolean isBoatDestroyed() {
        return destroyedParts == boatDimension;
    }
    
    /**
     * Method getWidth is used the get the width of a boat.
     *
     * @return int width.
     */
    public int getWidth() {
        return width;
    }
    
    /**
     * Method getHeight is used the get the height of a boat.
     *
     * @return int height.
     */
    public int getHeight() {
        return height;
    }
}
