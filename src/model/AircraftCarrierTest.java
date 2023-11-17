package model;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class AircraftCarrierTest.
 *
 * @author bonezf@usi.ch, carlo.pederiva@usi.ch 
 * @version 0.1
 */
public class AircraftCarrierTest{
    @Test
    public void AirCraftCarrierNameTest()
    {
        model.AircraftCarrier aircraft1 = new model.AircraftCarrier(1, 6);
        assertEquals("aircraftcarrier", aircraft1.getName());
    }
}

