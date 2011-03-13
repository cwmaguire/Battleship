/*
 * Copyright 2008 Entero Corporation. All Rights Reserved.
 * www.entero.com
 */
package factory;

import grid.GridAvailableSpaceCalculator;
import grid.Orientation;
import ship.Ship;

import java.util.ArrayList;
import java.util.List;

public class RandomShipFactory extends ShipFactory{
    private OrientationFactory orientationFactory = new RandomOrientationFactory();
    private GridPointFactory gridPointFactory = new RandomGridPointFactory();
    private GridAvailableSpaceCalculator spaceCalculator = new GridAvailableSpaceCalculator();
    private ShipPointArrayFactory pointArrayFactory = new ShipPointArrayFactory();
    List<Ship> ships = new ArrayList<Ship>();

    public List<Ship> generate() throws Exception{
        if(grid == null){
            throw new Exception("Cannot create ships for null Grid");
        }

        gridPointFactory.grid = grid;
        spaceCalculator.grid = grid;
        ships = new ArrayList<Ship>();

        if(grid == null){
            return ships;
        }

        for(Integer shipSize : shipSizes){
            ships.add(createShip(shipSize));
        }

        return ships;
    }

    private Ship createShip(Integer shipSize) throws Exception{
        setupFactories(shipSize);

        return createNonOverlappingShip();
    }

    private void setupFactories(Integer shipSize) throws Exception{
        Orientation shipOrientation = orientationFactory.generate();

        setupGridPointFactory(shipOrientation, shipSize);
        setupShipPointArrayFactory(shipOrientation, shipSize);
    }

    private void setupShipPointArrayFactory(Orientation shipOrientation, Integer shipSize) {
        pointArrayFactory.numPoints = shipSize;
        pointArrayFactory.orientation = shipOrientation;
    }

    private void setupGridPointFactory(Orientation shipOrientation, Integer shipSize) throws Exception{
        spaceCalculator.orientation = shipOrientation;
        spaceCalculator.spaceRequired = shipSize;
        gridPointFactory.setXSpaceAvailable(spaceCalculator.calculateAvailableXSpace());
        gridPointFactory.setYSpaceAvailable(spaceCalculator.calculateAvailableYSpace());
    }

    private Ship createNonOverlappingShip() throws Exception{
        Ship newShip = new Ship(pointArrayFactory.generate(gridPointFactory.generate()));

        while(ShipOverlapChecker.isShipOverlapping(newShip, ships)){
            newShip = new Ship(pointArrayFactory.generate(gridPointFactory.generate()));
        }

        return newShip;
    }
}
