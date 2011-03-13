package strategy;

import grid.Grid;

import java.awt.*;

public class BattleshipStrategy1 implements BattleshipStrategy{
    NextHitCalculator nextHitCalc = new NextHitCalculator();

    public void setGrid(Grid grid){
        nextHitCalc.grid = grid;
    }

    public void setResult(Point point, Result result){
        // ignore results for now
    }

    public Point getNextShot() throws Exception{
        return nextHitCalc.getNextHit();
    }
}
