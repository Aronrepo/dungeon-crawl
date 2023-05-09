package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.DayPeriod;

public class Player extends Actor {
    public Player(Cell cell, DayPeriod dayPeriod) {
        super(cell, dayPeriod);
    }

    public String getTileName() {
        return "player";
    }
}
