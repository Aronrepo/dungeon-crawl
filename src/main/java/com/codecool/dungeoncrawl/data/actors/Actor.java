package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.data.Drawable;

public abstract class Actor implements Drawable {
    protected Cell cell;
    private int health;
    private int power;

    public Actor(Cell cell, int health, int power) {
        this.cell = cell;
        this.cell.setActor(this);
        this.health = health;
        this.power = power;
    }

    protected boolean checkIfIsEmpty(Cell nextCell) {
        return nextCell.getActor() == null;
    }

    protected boolean checkForWall(Cell nextCell) {
        return !nextCell.getType().equals(CellType.WALL);
    }

    protected boolean checkForLava(Cell nextCell) {return nextCell.getType().equals(CellType.LAVA);}
    private boolean checkEnemy(Cell nextCell) {
        return nextCell.getType().getTileName().equals("enemy");
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int changeHealth) {
        health = changeHealth;
    }

    public int getPower() { return power; }

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
