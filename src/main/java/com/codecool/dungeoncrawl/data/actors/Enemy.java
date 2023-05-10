package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.DayPeriod;

public class Enemy extends Actor{

    private static final int PLAYER_HEALTH = 1;
    private static final int PLAYER_POWER = 1;
    public Enemy(Cell cell) {
        super(cell, PLAYER_HEALTH, PLAYER_POWER);
    }

    @Override
    public String getTileName() {
        return null;
    }


    public void move(int dx, int dy) {

        Cell nextCell = cell.getNeighbor(dx, dy);
        if (checkForWall(nextCell) && checkIfIsEmpty(nextCell)) {
            cell.setActor(null);
            nextCell.setActor(this);
            cell = nextCell;
        } else if (!checkIfIsEmpty(nextCell)) {
            if (checkPlayer(nextCell)) {
                System.out.println("attack");
            }
        }

    }

    private boolean checkPlayer(Cell nextCell) {
        return nextCell.getActor() instanceof Player;
    }
}
