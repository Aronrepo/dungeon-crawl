package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;

public class Enemy extends Actor{

    Cell cell;
    public Enemy(Cell cell) {
        super(cell);
    }

    @Override
    public String getTileName() {
        return null;
    }

    public String getTileType(){
        return "enemy";
    }

    public void move(int dx, int dy) {

        Cell nextCell = cell.getNeighbor(dx, dy);
        if (checkForWall(nextCell) && checkPlayer(nextCell)) {
            cell.setActor(null);
            nextCell.setActor(this);
            cell = nextCell;
        }

    }

    private boolean checkPlayer(Cell cell) {
        return cell.getActor() instanceof Player;
    }

    private boolean checkForWall(Cell nextCell){
        return !nextCell.getType().equals(CellType.WALL);
    }

//    public boolean getInstance(Enemy enemy) {
//        return enemy instanceof Enemy;
//    }
}
