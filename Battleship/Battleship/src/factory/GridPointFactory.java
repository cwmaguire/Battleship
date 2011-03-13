/*
 * Copyright 2008 Entero Corporation. All Rights Reserved.
 * www.entero.com
 */
package factory;

import grid.Grid;

import java.awt.*;

public abstract class GridPointFactory{
    public Grid grid;
    protected int xSpaceAvailable;
    protected int ySpaceAvailable;

    public abstract Point generate();

    public void setXSpaceAvailable(int xSpaceAvailable) throws Exception{
        if(xSpaceAvailable < 0){
            throw new Exception("Space available is negative");
        }
        this.xSpaceAvailable = xSpaceAvailable;
    }

    public void setYSpaceAvailable(int ySpaceAvailable) throws Exception{
        if (ySpaceAvailable < 0) {
            throw new Exception("Space available is negative");
        }
        this.ySpaceAvailable = ySpaceAvailable;
    }
}
