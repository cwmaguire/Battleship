/*
 * Copyright 2008 Entero Corporation. All Rights Reserved.
 * www.entero.com
 */
package factory;

import grid.Orientation;

import java.awt.*;

public class ShipPointArrayFactory{
    public int numPoints;
    public Orientation orientation;

    public Point[] generate(Point start){
        Point[] points = new Point[numPoints];
        points[0] = start;
        for(int i = 1; i < numPoints; i++){
            points[i] = translateCopiedPoint(points[i-1]);
        }
        return points;
    }

    public Point translateCopiedPoint(Point point){
        Point copiedPoint = new Point(point);
        if(Orientation.VERTICAL == orientation){
            copiedPoint.move(copiedPoint.x, copiedPoint.y + 1);
        }else{
            copiedPoint.move(copiedPoint.x + 1, copiedPoint.y);
        }
        return copiedPoint;
    }
}
