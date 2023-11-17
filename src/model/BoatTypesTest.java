package model;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class BoatTypesTest.
 *
 * @author bonezf@usi.ch, carlo.pederiva@usi.ch 
 * @version 0.1
 */
public class BoatTypesTest
{
    
    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */

    @Test
    public void BoatTypesTest1()
    {
        model.BoatTypes boatType1 = new model.BoatTypes(1, 1);
        assertEquals(1, boatType1.getWidth());
        assertEquals(1, boatType1.getHeight());
        assertEquals(false, boatType1.isBoatDestroyed());
    }
    
    @Test
    public void IsBoatDestroyedTest()
    {
        model.BoatTypes boatType4 = new model.BoatTypes(1, 1);
        boatType4.setIsBoatDestroyed();
        assertEquals(true, boatType4.isBoatDestroyed());
    }

    @Test
    public void DimensionsTest()
    {
        model.BoatTypes boatType1 = new model.BoatTypes(1, 3);
        assertEquals(3, boatType1.getHeight());
        assertEquals(1, boatType1.getWidth());
        assertEquals(3, boatType1.getBoatDimension());
    }

    @Test
    public void hasBeenAttackedTest()
    {
        model.Coordinates coordina1 = new model.Coordinates();
        model.BoatTypes boatType1 = new model.BoatTypes(1, 5);
        model.BoatsUtils boats1 = new model.BoatsUtils();
        model.GameBoard gameBoar1 = new model.GameBoard(8, BoatsUtils.differentBoats);
        model.PlaceShips placeShi1 = new model.PlaceShips(gameBoar1.createGameBoard());
        int[] int1 = placeShi1.generateShipCoords(8);
        boatType1.attackPosition(int1);
        assertEquals(true, boatType1.hasBeenAttacked(int1));
        int[] int4 = placeShi1.generateShipCoords(8);
        assertEquals(false, boatType1.hasBeenAttacked(int4));
    }

    @Test
    public void CopyRestoreTest()
    {
        model.BoatTypes boatType1 = new model.BoatTypes(1, 6);
        assertEquals(null, boatType1.getName());
        boatType1.restore();
    }

    @Test
    public void BoatCopyTest()
    {
        model.BoatTypes boatType1 = new model.BoatTypes(1, 3);
        assertNotNull(boatType1.copy());
    }
}




