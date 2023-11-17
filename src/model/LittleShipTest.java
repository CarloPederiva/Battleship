package model;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class LittleShipTest.
 *
 * @author bonezf@usi.ch, carlo.pederiva@usi.ch 
 * @version 0.1
 */
public class LittleShipTest {

    @Test
    public void LittleShipNameTest()
    {
        model.LittleShip littleSh1 = new model.LittleShip(1, 1);
        assertEquals("littleship", littleSh1.getName());
    }
}

