package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.DayPeriod;

public class Enemy extends Actor{


    public Enemy(Cell cell, DayPeriod dayPeriod, int health, int power) {
        super(cell, dayPeriod, health, power);
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
