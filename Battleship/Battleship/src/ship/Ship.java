package ship;/*
 * Copyright 2008 Entero Corporation. All Rights Reserved.
 * www.entero.com
 */

import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Ship {

    private Map<Point, ShipPoint> shipPoints = new HashMap<Point, ShipPoint>();

    public Ship(Point[] points) {
        for (Point point : points) {
            shipPoints.put(point, new ShipPoint());
        }
    }

    public Set<Point> getPoints() {
        return shipPoints.keySet();
    }

    public boolean hasPoint(Point pointToCheck) {
        return shipPoints.get(pointToCheck) != null;
    }

    public void hit(Point pointToHit) {
        ShipPoint shipPoint = shipPoints.get(pointToHit);
        if(shipPoint != null){
            shipPoint.isHit = true;
        }
    }

    public boolean isPointHit(Point point) {
        return shipPoints.get(point).isHit;
    }

    public boolean isSunk() {
        return areAllPointsHit();
    }

    private boolean areAllPointsHit() {
        for (ShipPoint shipPoint : shipPoints.values()) {
            if (!shipPoint.isHit) {
                return false;
            }
        }
        return true;
    }
}
