package model;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class WarShipTest.
 *
 * @author bonezf@usi.ch, carlo.pederiva@usi.ch 
 * @version 0.1
 */
public class WarShipTest
{
    @Test
    public void WarShipNameTest()
    {
        model.WarShip warShip2 = new model.WarShip(1, 5);
        assertEquals("warship", warShip2.getName());
    }
}

