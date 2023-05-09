package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.data.Drawable;

public abstract class Actor implements Drawable {
    protected Cell cell;
    private int health = 10;

    //private Skeleton skeleton;

    public Actor(Cell cell) {
        this.cell = cell;
        this.cell.setActor(this);
    }



    private boolean checkIfIsEmpty(Cell nextCell) {
        return nextCell.getActor() == null;
    }


    private void attack(Cell nextCell) {

        setHealth(getHealth()-2);
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public Cell getCell() {
        return cell;
    }

    public int getX() {
        return cell.getX();
    }

    public int getY() {
        return cell.getY();
    }
}
