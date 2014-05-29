package com.techies.towerdefensedelamorkitu.app.model;

/**
 * Created by Issam on 29/05/2014.
 */
public interface Item {

    int x;
    int y;

    ItemType type;

    // temps 2
    int destX;
    int destY;
    boolean isMoving;
}
