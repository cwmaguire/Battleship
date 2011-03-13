/*
 * Copyright 2008 Chris Maguire. All Rights Reserved.
 */
package grid;

import factory.ShipFactory;
import factory.ShipPointArrayFactory;
import ship.Ship;

import java.util.List;
import java.util.ArrayList;
import java.awt.*;

public class SimpleShipFactory extends ShipFactory {
    ShipPointArrayFactory shipPointArrayFactory;

    public List<Ship> generate() throws Exception {
        if (grid == null) {
            throw new Exception("Cannot create ships for null Grid");
        }

        List<Ship> ships = new ArrayList<Ship>();
        setupShipPointArrayFactory();
        ships.add(new Ship(shipPointArrayFactory.generate(new Point(0,0))));

        return ships;
    }

    private void setupShipPointArrayFactory() {
        shipPointArrayFactory = new ShipPointArrayFactory();
        shipPointArrayFactory.numPoints = grid.getWidth();
        shipPointArrayFactory.orientation = Orientation.HORIZONTAL;
    }
}
