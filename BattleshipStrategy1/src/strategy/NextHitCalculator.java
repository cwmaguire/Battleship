package strategy;

import grid.Grid;

import java.awt.*;

public class NextHitCalculator{
    public Grid grid;
    private Point previousHit;

    public Point getNextHit() throws Exception{
        if(isFirstHit()){
            return createAndStorePreviousHit(0,0);
        }

        int nextX = previousHit.x;
        int nextY = previousHit.y;

        if(nextX < getZeroBasedGridWidth()){
            nextX++;
        }else if(nextY < getZeroBasedGridHeight()){
            nextX = 0;
            nextY++;
        }else{
            throw new Exception("Ran out of grid points to hit!");
        }


        return createAndStorePreviousHit(nextX, nextY);
    }

    private int getZeroBasedGridHeight(){
        return grid.getHeight() - 1;
    }

    private int getZeroBasedGridWidth(){
        return grid.getWidth() - 1;
    }

    private boolean isFirstHit(){
        return previousHit == null;
    }

    private Point createAndStorePreviousHit(int x, int y){
        previousHit = new Point(x,y);
        return previousHit;
    }
}
