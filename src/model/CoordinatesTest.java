package model;



import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * The test class CoordinatesTest.
 *
 * @author bonezf@usi.ch, carlo.pederiva@usi.ch 
 * @version 0.1
 */
public class CoordinatesTest
{

    @Test
    public void CoordinatesTest()
    {
        model.Coordinates coordina1 = new model.Coordinates();
        assertEquals(false, coordina1.getIsUncoverd());
        coordina1.uncover();
    }

    @Test
    public void CoordinatesTest2()
    {
        model.Coordinates coordina1 = new model.Coordinates();
        model.Coordinates coordina2 = coordina1.copy();
        model.BoatTypes boatType1 = new model.BoatTypes(1, 3);
        coordina1.setShips(boatType1);
        assertEquals(boatType1, coordina1.getShips());
    }

    @Test
    public void CoordinatesCopyTest()
    {
        model.Coordinates coordina2 = new model.Coordinates();
        assertNotNull(coordina2.copy());
    }

    @Test
    public void CoordinatesCopyTest2()
    {
        model.Coordinates coordina3 = new model.Coordinates();
        model.Coordinates coordina1 = coordina3.copy();
        assertNotNull(coordina1);
        assertNotSame(coordina1, coordina1.copy());
    }
    

    @Test
    public void CoordinatesTest3()
    {
        model.Coordinates coordina4 = new model.Coordinates();
        coordina4.uncover();
        assertEquals(true, coordina4.getIsUncoverd());
        assertEquals(null, coordina4.getShips());
        assertNotNull(coordina4.copy());
        assertNotSame(null, coordina4.copy());
    }

    @Test
    public void CoordinatesTest4()
    {
        model.Coordinates coordina5 = new model.Coordinates();
        model.LittleShip littleSh1 = new model.LittleShip(1, 1);
        model.WarShip warShip1 = new model.WarShip(1, 5);
        coordina5.setShips(littleSh1);
        assertEquals(littleSh1, coordina5.getShips());
        model.Coordinates coordina5copy = coordina5.copy();
        assertNotSame(coordina5, coordina5copy);
        coordina5copy.setShips(warShip1);
        assertNotNull(coordina5copy.getShips());
        assertNotNull(coordina5copy.copy());
    }
}






