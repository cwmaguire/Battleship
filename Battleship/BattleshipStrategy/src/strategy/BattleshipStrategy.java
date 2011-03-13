package strategy;

import grid.Grid;

import java.awt.*;

public interface BattleshipStrategy{
    public void setGrid(Grid grid);
    public void setResult(Point shot, Result result);
    public Point getNextShot() throws Exception;
}
