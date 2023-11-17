package model;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class HelperShipTest.
 *
 * @author bonezf@usi.ch, carlo.pederiva@usi.ch 
 * @version 0.1
 */
public class HelperShipTest {
    @Test
    public void HelperShipNameTest()
    {
        model.HelperShip helperSh1 = new model.HelperShip(1, 3);
        assertEquals("helpership", helperSh1.getName());
    }
}

