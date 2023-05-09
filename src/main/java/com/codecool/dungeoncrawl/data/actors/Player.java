package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;

public class Player extends Actor {

    public Player(Cell cell) {
        super(cell);
    }

    public void move(int dx, int dy) {

        Cell nextCell = cell.getNeighbor(dx, dy);
        if (checkForWall(nextCell) && !checkEnemy(nextCell)) {
            cell.setActor(null);
            nextCell.setActor(this);
            cell = nextCell;
        }

    }

    private boolean checkEnemy(Cell cell) {
        return cell.getActor() instanceof Enemy;
    }

    public String getTileName() {
        return "player";
    }

    private boolean checkForWall(Cell nextCell){
        return !nextCell.getType().equals(CellType.WALL);
    }
}
