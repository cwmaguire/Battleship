package factory;

import grid.Grid;
import ship.Ship;

import java.util.List;
import java.util.ArrayList;

public abstract class ShipFactory{
    public List<Integer> shipSizes = new ArrayList<Integer>();
    public Grid grid;

    public abstract List<Ship> generate() throws Exception;
}
