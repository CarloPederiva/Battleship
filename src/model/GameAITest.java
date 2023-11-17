package model;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class GameAITest.
 *
 * @author bonezf@usi.ch, carlo.pederiva@usi.ch 
 * @version 0.1
 */
public class GameAITest
{

    @Test
    public void CoordsTest()
    {
        model.GameAI gameAI1 = new model.GameAI(2);
        int[] int1 = gameAI1.getCoords();
        int[] int2 = gameAI1.getCoords();
        assertNotSame(int1, int2);
        int[] int3 = gameAI1.getCoords();
        assertNotSame(int1, int3);
        int[] int4 = gameAI1.getCoords();
        assertNotSame(int1, int4);
    }
}


