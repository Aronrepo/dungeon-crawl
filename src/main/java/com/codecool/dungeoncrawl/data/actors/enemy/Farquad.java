package com.codecool.dungeoncrawl.data.actors.enemy;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.DayPeriod;
import com.codecool.dungeoncrawl.data.actors.Enemy;

public class Farquad extends Enemy {

    private static final int FARQUAD_HEALTH = 10;
    private static final int FARQUAD_POWER = 3;
    public Farquad(Cell cell, DayPeriod dayPeriod) {
        super(cell, dayPeriod, FARQUAD_HEALTH, FARQUAD_POWER);
    }

    @Override
    public String getTileName() {
        return "farquad";
    }
}
