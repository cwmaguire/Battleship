package factory;

import java.awt.*;
import java.util.Random;

public class RandomGridPointFactory extends GridPointFactory{
    private Random random = new Random();

    public Point generate(){
        int x = calculateRandomAllowableCoordinate(xSpaceAvailable);
        int y = calculateRandomAllowableCoordinate(ySpaceAvailable);
        return new Point(x,y);
    }

    private int calculateRandomAllowableCoordinate(int allowableRange){
        int coordinate = Math.abs(random.nextInt()) % allowableRange;
        //System.out.println("Coordinate is " + coordinate);
        return coordinate;
    }
}
