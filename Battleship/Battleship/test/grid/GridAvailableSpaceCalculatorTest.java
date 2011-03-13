package grid;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import java.util.*;
import java.util.List;
import java.awt.*;

import ship.Ship;

public class GridAvailableSpaceCalculatorTest extends TestCase {
    private Grid grid;
    GridAvailableSpaceCalculator gridAvailSpaceCalc;

    @Before
    public void setUp(){
        grid = new Grid();
        gridAvailSpaceCalc = new GridAvailableSpaceCalculator();
        gridAvailSpaceCalc.grid = grid;
    }

    @Test
    public void testCalculateAvailableSpace() {
        gridAvailSpaceCalc.orientation = Orientation.HORIZONTAL;

        gridAvailSpaceCalc.spaceRequired = grid.getWidth();
        Assert.assertEquals("A ship the size of the width grid still has one column it can start in", 1, gridAvailSpaceCalc.calculateAvailableXSpace());
        Assert.assertEquals("Grid space calc isn't returning grid width for opposite orientation", grid.getWidth(), gridAvailSpaceCalc.calculateAvailableYSpace());

        gridAvailSpaceCalc.spaceRequired = 0;
        Assert.assertEquals("With zero space required there should be the full width of the grid to place a ship", grid.getWidth(), gridAvailSpaceCalc.calculateAvailableXSpace());

        gridAvailSpaceCalc.orientation = Orientation.VERTICAL;
        Assert.assertEquals("With zero space required there should be the full height of the grid to place a ship", grid.getHeight(), gridAvailSpaceCalc.calculateAvailableYSpace());

        gridAvailSpaceCalc.spaceRequired = grid.getWidth();
        Assert.assertEquals("A ship the size of the height grid still has one row it can start in", 1, gridAvailSpaceCalc.calculateAvailableYSpace());
        Assert.assertEquals("Grid space calc isn't returning grid height for opposite orientation", grid.getHeight(), gridAvailSpaceCalc.calculateAvailableXSpace());
    }
}
