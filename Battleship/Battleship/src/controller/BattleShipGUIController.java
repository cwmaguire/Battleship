/*
 * Copyright 2008 Chris Maguire. All Rights Reserved.
 */
package controller;

import strategy.BattleshipStrategy;

import java.util.EventListener;
import java.util.List;
import java.util.ArrayList;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.awt.*;

public class BattleShipGUIController {

    protected PropertyChangeSupport propertyChangeSupport;


    public void createNewGrid(){

    }

    public void runStrategy(BattleshipStrategy strategy){

    }

    public List<BattleshipStrategy> getStrategies(){
        return new ArrayList<BattleshipStrategy>();
    }

    public Point getNextHit(){
        return new Point(0,0);
    }

    public boolean areAllShipsSunk(){
        return false;
    }

}
