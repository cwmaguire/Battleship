package runner;

import strategy.BattleshipStrategy1;
import strategy.Result;
import grid.Grid;

import java.awt.*;

public class ChrisStrategyRunner{
    BattleshipStrategy1 chrisStrategy;
    Grid grid;
    int numberOfShots;

    public static void main(String[] args){
        int numberOfShots;
        ChrisStrategyRunner runner = new ChrisStrategyRunner();
        System.out.println("Starting ChristStrategyRunner");
        numberOfShots = runner.run();
        System.out.println("Finished ChristStrategyRunner in " + numberOfShots + " shots");
    }

    public ChrisStrategyRunner(){
        grid = new Grid();
        chrisStrategy = new BattleshipStrategy1();

        grid.createAndRegisterShips();
        System.out.println(grid);
        chrisStrategy.setGrid(grid);
    }

    public int run(){
        numberOfShots = 0;
        Point shot;

        while(!grid.areAllShipsSunk()){
            try{
                shot = chrisStrategy.getNextShot();
            }catch(Exception e){
                System.out.println("Could not get next shot from strategy: " + e.getMessage());
                return numberOfShots;
            }

            if(grid.checkAndRecordShot(shot)){
                //System.out.println("Shot " + shot + " hit");
                chrisStrategy.setResult(shot, Result.HIT);
            }else{
                //System.out.println("Shot " + shot + " miss");
                chrisStrategy.setResult(shot, Result.MISS);
            }

            numberOfShots++;
        }
        return numberOfShots;
    }
}
