/*
 * Copyright 2008 Chris Maguire. All Rights Reserved.
 */
package strategy;

import grid.Grid;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;

public class NextHitCalculatorTest extends TestCase{
    NextHitCalculator nextHitCalc;

    @Before
    public void setUp(){
        nextHitCalc = new NextHitCalculator();
        nextHitCalc.grid = new Grid();
        nextHitCalc.grid.createAndRegisterShips();
    }

    @Test
    public void testGetNextHitNoMorePointsException(){
        for(int i = 0; i < 101; i++){
            try{
                nextHitCalc.getNextHit();
            } catch(Exception e){
                return;
            }
        }
        Assert.fail("Expected exception not thrown");
    }

    @Test
    public void testGetFirstHit() throws Exception{
        Point firstHit = nextHitCalc.getNextHit();
        Assert.assertEquals(new Point(0,0), firstHit);
    }
}