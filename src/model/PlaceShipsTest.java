package model;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class PlaceShipsTest.
 *
 * @author bonezf@usi.ch, carlo.pederiva@usi.ch 
 * @version 0.2
 */
public class PlaceShipsTest
{
    
    @Test
    public void PlaceShipSetTest()
    {
        model.GameBoard gameBoar3 = new model.GameBoard(8, BoatsUtils.differentBoats);
        model.Coordinates[][] coordina1 = gameBoar3.createGameBoard();
        model.PlaceShips placeShi1 = new model.PlaceShips(coordina1);
        model.BoatTypes boatType1 = new model.BoatTypes(1, 1);
        placeShi1.setBoat(1, 1, 'L', boatType1);
        placeShi1.setLeftPosition(1, 1, boatType1);
        placeShi1.setRightPosition(1, 1, boatType1);
        placeShi1.setUpPosition(1, 1, boatType1);
        placeShi1.setDownPosition(1, 1, boatType1);
        placeShi1.setBoat(1, 1, 'D', boatType1);
    }
    
    @Test
    public void PlaceShipCheckFalsePos()
    {
        model.GameBoard gameBoar1 = new model.GameBoard(8, BoatsUtils.differentBoats);
        model.Coordinates[][] coordina2 = gameBoar1.createGameBoard();
        model.PlaceShips placeShi2 = new model.PlaceShips(coordina2);
        model.HelperShip helperSh1 = new model.HelperShip(1, 3);
        placeShi2.setBoat(3, 3, 'U', helperSh1);
        assertEquals(false, placeShi2.checkRightPosition(7, 7, helperSh1));
        assertEquals(false, placeShi2.checkDownPosition(7, 7, helperSh1));
    }
}






