package com.codecool.dungeoncrawl.data.actors.enemy;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.DayPeriod;
import com.codecool.dungeoncrawl.data.actors.Enemy;

public class Farquad extends Enemy {
    public Farquad(Cell cell, DayPeriod dayPeriod) {
        super(cell, dayPeriod);
    }

    @Override
    public String getTileName() {
        return "farquad";
    }
}
