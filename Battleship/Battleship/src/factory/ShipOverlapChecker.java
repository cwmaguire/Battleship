package factory;

import ship.Ship;

import java.util.List;
import java.awt.*;

public class ShipOverlapChecker {

    public static boolean isShipOverlapping(Ship newShip, List<Ship>shipsToCheck){
        for(Ship shipToCheck : shipsToCheck){
            if(doesShipOverlap(newShip, shipToCheck)){
                return true;
            }
        }
        return false;
    }

    private static boolean doesShipOverlap(Ship ship1, Ship ship2){
        for(Point point1 : ship1.getPoints()){
            for(Point point2 : ship2.getPoints()){
                if(point1.equals(point2)){
                    return true;
                }
            }
        }
        return false;
    }
}
