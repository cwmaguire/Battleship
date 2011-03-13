package grid;

import factory.RandomShipFactory;
import factory.ShipFactory;
import ship.Ship;
import ship.ShipType;

import java.util.*;
import java.util.List;
import java.awt.*;/*
 * Copyright 2008 Entero Corporation. All Rights Reserved.
 * www.entero.com
 */

public class Grid {
    public List<Integer> shipSizes = Arrays.asList(ShipType.AIRCRAFT_CARRIER.size,
            ShipType.BATTLESHIP.size,
            ShipType.CRUISER.size,
            ShipType.DESTROYER.size,
            ShipType.DESTROYER.size,
            ShipType.SUBMARINE.size,
            ShipType.SUBMARINE.size);
    private int width = 10;
    private int height = 10;
    private List<Ship> ships = new ArrayList<Ship>();
    private Map<Point, Ship> pointShips;
    private ShipFactory shipFactory = new RandomShipFactory();

    public Grid(){
    }

    public Grid(int width, int height) throws Exception{
        this.width = width;
        this.height = height;
        shipFactory = new RandomShipFactory();

        if(width < 1 || height < 1){
            throw new Exception("Grid size cannot be less than 1 x 1");
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setShipFactory(ShipFactory shipFactory) {
        this.shipFactory = shipFactory;
    }

    public List<Ship> getShips() {
        return ships;
    }

    public Map<Point, Ship> getPointShips() {
        return pointShips;
    }

    public void createAndRegisterShips() {
        shipFactory.grid = this;
        shipFactory.shipSizes = shipSizes;
        try {
            ships = shipFactory.generate();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Could not create ships: " + e.getMessage());
        }
        registerPointShips(ships);
    }

    public void createAndRegisterShips(List<Ship> ships){
        this.ships = ships;
        registerPointShips(ships);
    }

    public int getDimesion(Orientation orientation) {
        if (orientation == Orientation.VERTICAL) {
            return height;
        } else {
            return width;
        }
    }

    private void registerPointShips(List<Ship> ships) {
        pointShips = new HashMap<Point, Ship>();

        for (Ship ship : ships) {
            registerPointShip(ship);
        }
    }

    private void registerPointShip(Ship ship) {
        for (Point point : ship.getPoints()) {
            pointShips.put(point, ship);
        }
    }

    public boolean areAllShipsSunk() {
        for (Ship ship : ships) {
            if (!ship.isSunk()) {
                return false;
            }
        }
        return true;
    }

    public boolean checkAndRecordShot(Point shotPoint) {
        Ship ship = pointShips.get(shotPoint);
        if (ship != null) {
            ship.hit(shotPoint);
            return true;
        }
        return false;
    }

    public String toString() {
        char shipChar = '#';
        char ocean = '~';
        char[][] gridPoints = new char[width][height];

        StringBuilder stringBuilder = new StringBuilder();
        for (int y = 0; y < height; y++){
            for(int x = 0; x < width; x++){
                gridPoints[x][y] = ocean;
            }
        }

        for(Ship ship : ships){
            for(Point point : ship.getPoints()){
                gridPoints[point.x][point.y] = shipChar;
            }
        }

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                stringBuilder.append(gridPoints[x][y]);
            }
            stringBuilder.append("\n");
        }

        return stringBuilder.toString();
    }
}
