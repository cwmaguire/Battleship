/*
 * Copyright 2008 Entero Corporation. All Rights Reserved.
 * www.entero.com
 */
package grid;

import ship.Ship;

public class GridAvailableSpaceCalculator{
    public Grid grid;
    public int spaceRequired;
    public Orientation orientation;

    public int calculateAvailableXSpace(){
        if(Orientation.HORIZONTAL == orientation){
            if(spaceRequired < 1){
                return grid.getWidth();
            }else{
                return grid.getWidth() - spaceRequired + 1;
            }
        }else{
            return grid.getWidth();
        }
    }

    public int calculateAvailableYSpace(){
        if(Orientation.VERTICAL == orientation){
            if(spaceRequired < 1){
                return grid.getHeight();
            }else{
                return grid.getHeight() - spaceRequired + 1;
            }
        } else{
            return grid.getHeight();
        }
    }
}
