package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.data.DayPeriod;
import com.codecool.dungeoncrawl.data.Drawable;

public abstract class Actor implements Drawable {
    protected Cell cell;
    private DayPeriod dayPeriod;
    private int health = 10;

    public Actor(Cell cell, DayPeriod dayPeriod) {
        this.cell = cell;
        this.dayPeriod = dayPeriod;
        this.cell.setActor(this);
    }







    protected boolean checkIfIsEmpty(Cell nextCell) {
        return nextCell.getActor() == null;
    }

    protected boolean checkForWall(Cell nextCell) {
        return !nextCell.getType().equals(CellType.WALL);
    }


    private boolean checkEnemy(Cell nextCell) {
        return nextCell.getType().getTileName().equals("enemy");
    }

    public int getHealth() {
        return health;
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
