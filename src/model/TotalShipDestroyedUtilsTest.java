package model;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

/**
 * The test class TotalShipDestroyedTest.
 *
 * @author bonezf@usi.ch, carlo.pederiva@usi.ch 
 * @version 0.2
 */

public class TotalShipDestroyedUtilsTest {

    @Test
    public void ShipDestroyedTrueTest()
    {
        model.TotalShipDestroyedUtils totalShi1 = new model.TotalShipDestroyedUtils();
        model.BoatTypes boatType1 = new model.BoatTypes(1, 3);
        ArrayList<BoatTypes> Boats = new ArrayList<BoatTypes>();
        Boats.add(boatType1);
        assertEquals(false, model.TotalShipDestroyedUtils.totalShipsDestroyed(Boats));
    }

    @Test
    public void ShipDestroyedFalseTest()
    {
        ArrayList<BoatTypes> Boats = new ArrayList<BoatTypes>();
        BoatTypes warShip = new WarShip(1, 5);
        Boats.clear(); //different ArrayList from the previous Method.
        assertEquals(true, model.TotalShipDestroyedUtils.totalShipsDestroyed(Boats));
    }

    @Test
    public void BoatsDestroyedTest()
    {
        model.BoatTypes boatType1 = new model.BoatTypes(1, 3);
        ArrayList<BoatTypes> Boats = new ArrayList<BoatTypes>();
        Boats.add(boatType1);
        boatType1.setIsBoatDestroyed();
        assertEquals(true, boatType1.isBoatDestroyed());
    }
}






