package model;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class BoatsTest.
 *
 * @author bonezf@usi.ch, carlo.pederiva@usi.ch 
 * @version 0.1
 */
public class BoatsUtilsTest {
    @Test
    public void BoatsTest1()
    {
        model.BoatsUtils boats1 = new model.BoatsUtils();
        model.BoatsUtils.addBoats();
        model.BoatsUtils.restoreBoats();
    }
}


