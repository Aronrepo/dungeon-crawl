package com.codecool.dungeoncrawl.data.actors.enemy;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.data.actors.Enemy;

public class Farquad extends Enemy {

    private static final int FARQUAD_HEALTH = 40;
    private static final int FARQUAD_POWER = 10;
    public Farquad(Cell cell) {
        super(cell, FARQUAD_HEALTH, FARQUAD_POWER);
    }

    public void checkIfDead() {
        if (this.getHealth() <= 0) {
            cell.setType(CellType.GRAVE);
            }
    }

    @Override
    public String getTileName() {
        return "farquad";
    }
}
