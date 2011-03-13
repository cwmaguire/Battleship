package grid;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import java.awt.*;

public class GridTest extends TestCase {
    Grid grid;

    @Before
    public void setUp(){
        grid = new Grid();
        grid.setShipFactory(new SimpleShipFactory());
        grid.createAndRegisterShips();
    }

    @Test
    public void testCreatingGridWithDifferentDimensions(){
        try{
            grid = new Grid(2,2);
        }catch(Exception e){
            Assert.fail("Creating a 2x2 Grid should not fail.");
        }
        Assert.assertEquals("New Grid width should be 2", 2, grid.getWidth());
        Assert.assertEquals("New Grid height should be 2",2, grid.getHeight());

    }

    @Test
    public void testCreatingGridWithBadHeight(){
        try {
            grid = new Grid(1, 0);
        } catch (Exception e) {
            return;
        }
        Assert.fail("Creating a Grid with a height less than 1 should have blown up");
    }

    @Test
    public void testCreatingGridWithBadWidth() {
        try {
            grid = new Grid(0, 1);
        } catch (Exception e) {
            return;
        }
        Assert.fail("Creating a Grid with a width less than 1 should have blown up");
    }

    @Test
    public void testCreatingGridWithBadWidthAndHeight() {
        try {
            grid = new Grid(0, 0);
        } catch (Exception e) {
            return;
        }
        Assert.fail("Creating a Grid with a width and height less than 1 should have blown up");
    }

    @Test
    public void testCreateAndRegisterShips(){
        Assert.assertEquals("SimpleShipFactory should create one ship", grid.getShips().size(), 1);
        Assert.assertEquals("One ship as wide as the grid should have been registered", grid.getWidth(), grid.getPointShips().size());
    }

    @Test
    public void testHittingAShip(){
        Assert.assertTrue("SimpleShipFactory should have instantiated a ship at (0,0)", grid.checkAndRecordShot(new Point(0,0)));
        Assert.assertFalse("SimpleShipFactory should not have instantiated any ships on any but the 0th row", grid.checkAndRecordShot(new Point(0,1)));
    }

    @Test
    public void testSinkingAllShips(){
        for(int i = 0; i < 10; i++){
            grid.checkAndRecordShot(new Point(i, 0));
        }

        Assert.assertTrue("Hitting every cell in the first row should have sunk the ship SimpleShipFactory created", grid.areAllShipsSunk());
    }
}
