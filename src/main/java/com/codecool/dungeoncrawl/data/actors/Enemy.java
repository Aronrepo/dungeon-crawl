package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.DayPeriod;

public class Enemy extends Actor{

    public Enemy(Cell cell, int health, int power) {
        super(cell, health, power);

    }

    @Override
    public String getTileName() {
        return null;
    }

    protected boolean checkPlayer(Cell nextCell) {
        return nextCell.getActor() instanceof Player;
    }
}
