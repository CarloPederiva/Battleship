package model;

import java.util.ArrayList;
import java.util.Random;


/**
 * Class placeShips is responsible for placing the ships on the gameboard.
 *
 * @author bonezf@usi.ch, carlo.pederiva@usi.ch 
 * @version 0.3
 */

public class PlaceShips {
    
    private Coordinates[][] gameBoard;

    /**
     * PlaceShips Constructor.
     *
     * @param gameBoard is the grid on which ships are generated.
     */
    public PlaceShips(Coordinates[][] gameBoard) {
        this.gameBoard = gameBoard;
    }
    

    /**
     * Method createPlaceShips sets the boats on the gameBoard,the while loop 
     * checks until the number of ship given is less than the 
     * number of ship placed is the placement of a ship is correct and these 
     * do not overlay each other.
     * 
     * @param gameBoats is an array of Boatypes. 
     * 
     * @return the gameBoard with ships on water.
     */
    public Coordinates[][] createPlaceShips(ArrayList<BoatTypes> gameBoats) {
        int coordsI = 0;
        while (coordsI < gameBoats.size()) { 
            int[] location = generateShipCoords(gameBoard.length);
            char dir = checkPosition(location[0], location[1], gameBoats.get(coordsI));
            if (dir != 'N') {
                setBoat(location[0], location[1], dir, gameBoats.get(coordsI));
                coordsI++;
            }
        }
        return gameBoard;
    }
    
    /**
     * Method setBoat does not return anything but is is used to control the
     * direction and position of the boats.
     *
     * @param posX are the x coords.
     * @param posY are the y coords.
     * @param direction indicates the directions which the boat are facing.
     * @param definedBoats checks the boat types which were assigned to be present in the game.
     */
    public void setBoat(int posX, int posY, char direction, BoatTypes definedBoats) {
        if (direction == 'L') {
            setLeftPosition(posX, posY, definedBoats);
        }
        
        if (direction == 'R') {
            setRightPosition(posX, posY, definedBoats);
        }
        
        if (direction == 'U') {
            setUpPosition(posX, posY, definedBoats);
        }
        
        if (direction == 'D') {
            setDownPosition(posX, posY, definedBoats);
        }
    } 
    
    /**
     * Method setPosition sets the position of the boats in the gameboard.
     *
     * @param startX checks where the int x starts. 
     * @param startY checks where the int y starts.
     * @param deltaX change int X in position.
     * @param deltaY change int Y in position.
     * @param check is a BoatType.
     */
    private void setPosition(int startX, int startY, int deltaX, int deltaY, BoatTypes check) {
        for (int i = 0; i < check.getHeight(); i++) {
            gameBoard[startY + deltaY * i][startX + deltaX * i].setShips(check);
        }
    }

    /**
     * Method setLeftPosition checks if to the left there is an empty position 
     * in order to set the boat on the according coordinate.
     *
     * @param posLeftX checks the left position on the X Axis.
     * @param posLeftY checks the left position on the Y Axis.
     * @param check is a BoatType.
     */
    public void setLeftPosition(int posLeftX, int posLeftY, BoatTypes check) {
        setPosition(posLeftX, posLeftY, -1, 0, check);
    }
    
    /**
     * Method setRightPosition checks if to the right there is an empty position 
     * in order to set the boat on the according coordinate.
     *
     * @param posRightX checks the right position on the X Axis.
     * @param posRightY checks the right position on the Y Axis.
     * @param check is a BoatType.
     */
    public void setRightPosition(int posRightX, int posRightY, BoatTypes check) {
        setPosition(posRightX, posRightY, 1, 0, check);
    }
    
    /**
     * Method setUpPosition checks if to up there is an empty position in order 
     * to set the boat on the according coordinate.
     *
     * @param posUpX checks the up position on the X Axis.
     * @param posUpY checks the up position on the Y Axis.
     * @param check is a BoatType.
     */
    public void setUpPosition(int posUpX, int posUpY, BoatTypes check) {
        setPosition(posUpX, posUpY, 0, -1, check);
    }
    
    /**
     * Method setDownPosition checks if down there is an empty position in order 
     * to set the boat on the according coordinate.
     *
     * @param posDownX checks the down position on the X Axis.
     * @param posDownY checks the down position on the Y Axis.
     * @param check is a BoatType.
     */
    public void setDownPosition(int posDownX, int posDownY, BoatTypes check) {
        setPosition(posDownX, posDownY, 0, 1, check);
    }
    
    /**
     * Method checkPosition checks if the integers x and y are already taken and 
     * if it has to be moved to the left, right, up or down.
     *
     * @param posX position of the X Axis.
     * @param posY position of the Y Axis.
     * @param check is a BoatType.
     * @return The return value is either L, R, U, D or N in form of a char.
     */
    public char checkPosition(int posX, int posY, BoatTypes check) {
        if (checkLeftPosition(posX, posY, check)) {
            return 'L';
        } 
        if (checkRightPosition(posX, posY, check)) {
            return 'R';
        }
        if (checkUpPosition(posX, posY, check)) { 
            return 'U';
        }
        if (checkDownPosition(posX, posY, check)) {
            return 'D';
        }
        return 'N';
    } 
    
    /**
     * Method checkLeftPosition checks if the to be placed boat is in the assignated 
     * field and if it can be placed there by checking if there is space to the left.
     *
     * @param posCheckLeftX checks if the position to the left on the X Axis is 
     *        available/taken.
     * @param posCheckLeftY A checks if the position to the left on the Y Axis is 
     *        available/taken.
     * @param check is a BoatType.
     * @return The return value true or false.
     */
    public boolean checkLeftPosition(int posCheckLeftX, int posCheckLeftY, BoatTypes check) {
        for (int i = 0; i < check.getHeight(); i++) {
            if (posCheckLeftX < 0) {
                return false;
            } else { 
                if (gameBoard[posCheckLeftY][posCheckLeftX].getShips() != null) {
                    return false;
                }
            } 
            posCheckLeftX--;
        } 
        return true;
    }
    
    /**
     * Method checkRightPosition checks if the to be placed boat is in the assignated 
     * field and if it can be placed there by checking if there is space to the right.
     *
     * @param posCheckRightX checks if the position to the right on the X Axis is 
     *        available or taken.
     * @param posCheckRightY checks if the position to the right on the X Axis is 
     *        available or taken.
     * @param check is a BoatType
     * @return The return value true or false.
     */
    public boolean checkRightPosition(int posCheckRightX, int posCheckRightY, BoatTypes check) {
        for (int i = 0; i < check.getHeight(); i++) {
            if (posCheckRightX > (gameBoard.length - 1)) {
                return false;
            } else { 
                if (gameBoard[posCheckRightY][posCheckRightX].getShips() != null) {
                    return false;
                }
            } 
            posCheckRightX++;
        } 
        return true;
    }
    
    /**
     * Method checkUpPosition checks if the to be placed boat is in the assignated 
     * field and if it can be placed there by checking if there is space to the 
     * up position.
     *
     * @param posCheckUpX checks if the position to the upside on the X Axis is 
     *        available or taken.
     * @param posCheckUpY checks if the position to the upside on the Y Axis is 
     *        available or taken.
     * @param check is a BoatType
     * @return The return value true or false.
     */
    public boolean checkUpPosition(int posCheckUpX, int posCheckUpY, BoatTypes check) {
        for (int i = 0; i < check.getHeight(); i++) {
            if (posCheckUpY < 0) {
                return false;
            } else { 
                if (gameBoard[posCheckUpY][posCheckUpX].getShips() != null) {
                    return false;
                }
            } 
            posCheckUpY--;
        } 
        return true;
    }
    
    /**
     * Method checkDownPosition checks if the to be placed boat is in the assignated 
     * field and if it can be placed there by checking if there is space to the 
     * down position.
     *
     * @param posCheckDownX checks if the position to the downside on the X Axis is 
     *        available or taken.
     * @param posCheckDownY checks if the position to the downside on the Y Axis 
     *        is available or taken.
     * @param check is a BoatType.
     * @return The return value true or false.
     */
    public boolean checkDownPosition(int posCheckDownX, int posCheckDownY, BoatTypes check) {
        for (int i = 0; i < check.getHeight(); i++) {
            if (posCheckDownY > (gameBoard.length - 1)) {
                return false;
            } else { 
                if (gameBoard[posCheckDownY][posCheckDownX].getShips() != null) {
                    return false;
                }
            } 
            posCheckDownY++;
        } 
        return true;
    }
    
    /**
     * Method generateShipCoords if the ship can be generated on the gameboard 
     * position which is forseen to be randomly placed.
     *
     * @param gameBoardLength length of the gameboard.
     * @return The return value coords.
     */
    public int[] generateShipCoords(int gameBoardLength) {
        int [] coords = new int[2];
        for (int i = 0; i < coords.length; i++) {
            coords[i] = new Random().nextInt(gameBoardLength - 1);
        }
        return coords;
    }
}
