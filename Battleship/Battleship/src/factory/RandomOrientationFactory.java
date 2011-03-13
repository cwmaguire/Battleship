/*
 * Copyright 2008 Entero Corporation. All Rights Reserved.
 * www.entero.com
 */
package factory;

import grid.Orientation;

import java.util.Random;

public class RandomOrientationFactory extends OrientationFactory{
    public Orientation generate(){
        int random = new Random().nextInt();
        if(random % 2 == 0){
            return Orientation.HORIZONTAL;
        }else{
            return Orientation.VERTICAL;
        }
    }
}