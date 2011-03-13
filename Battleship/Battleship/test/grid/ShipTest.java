package grid;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import ship.Ship;

import java.util.Arrays;
import java.awt.*;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

public class ShipTest extends TestCase {
    Ship ship;
    List<Point> points;

    @Before
    public void setUp(){
        points = Arrays.asList(new Point(0,0), new Point(0,1), new Point(0,2));
        ship = new Ship(points.toArray(new Point[points.size()]));
    }

    @Test
    public void testShipPointSetup(){
        Assert.assertTrue("Ship does not contain specified point", ship.hasPoint(points.get(0)));
        Assert.assertFalse("Ship contains unspecified point", ship.hasPoint(new Point(100,100)));
        Assert.assertEquals("Ship does not contain all specified points", new HashSet<Point>(ship.getPoints()), new HashSet<Point>(points));
    }

    @Test
    public void testHit(){
        Point hitPoint = points.get(0);
        Point nonHitPoint = points.get(1);
        Assert.assertFalse("Point was hit before any shots fired.", ship.isPointHit(hitPoint));
        ship.hit(hitPoint);
        Assert.assertTrue("Point was not hit after a shot was fired at it", ship.isPointHit(hitPoint));
        Assert.assertFalse("Point was hit but was not shot at", ship.isPointHit(nonHitPoint));
    }

    @Test
    public void testSunk(){
        Assert.assertFalse("Ship was sunk with no shots fired", ship.isSunk());
        ship.hit(points.get(0));
        Assert.assertFalse("Ship was sunk with only one shot", ship.isSunk());
        for(int i = 1; i < points.size(); i++){
            ship.hit(points.get(i));
        }
        Assert.assertTrue("Ship was not sunk even though every point was hit", ship.isSunk());

    }
}
