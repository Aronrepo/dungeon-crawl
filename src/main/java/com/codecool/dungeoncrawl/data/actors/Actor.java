package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.data.Drawable;

public abstract class Actor implements Drawable {
    private Cell cell;
    private int health = 10;

    private Skeleton skeleton;

    public Actor(Cell cell) {
        this.cell = cell;
        this.cell.setActor(this);
    }

    public void move(int dx, int dy) {

        Cell nextCell = cell.getNeighbor(dx, dy);
        if (checkForWall(nextCell) && checkIfIsEmpty(nextCell)) {
            cell.setActor(null);
            nextCell.setActor(this);
            cell = nextCell;
        } else if (checkEnemy(nextCell)) {
            attack(nextCell);
        }
    }

    private boolean checkIfIsEmpty(Cell nextCell) {
        return nextCell.getActor() == null;
    }
    private boolean checkForWall(Cell nextCell){
        return !nextCell.getType().equals(CellType.WALL);
    }

    private boolean checkEnemy(Cell nextCell) {
        return nextCell.getTileType().equals("enemy");
    }

    private void attack(Cell nextCell) {
        nextCell.getActor()
    }

    public int getHealth() {
        return health;
    }

    public boolean

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
