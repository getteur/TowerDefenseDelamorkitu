package com.techies.towerdefensedelamorkitu.app.model;

/**
 * Created by Issam on 29/05/2014.
 */
public abstract class Item {

    private int x;
    private int y;

    private ItemType type;

    // temps 2
    private int destX;
    private int destY;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public ItemType getType() {
        return type;
    }

    public void setType(ItemType type) {
        this.type = type;
    }

    public int getDestX() {
        return destX;
    }

    public void setDestX(int destX) {
        this.destX = destX;
    }

    public int getDestY() {
        return destY;
    }

    public void setDestY(int destY) {
        this.destY = destY;
    }

    public boolean isMoving() {
        // TODO : UPDATE THIS.
        return true;
    }

}