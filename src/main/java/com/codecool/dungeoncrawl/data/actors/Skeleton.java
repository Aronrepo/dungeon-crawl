package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.DayPeriod;

public class Skeleton extends Actor {
    public Skeleton(Cell cell, DayPeriod dayPeriod) {
        super(cell, dayPeriod);
    }

    @Override
    public String getTileName() {
        return "skeleton";
    }
}
