package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.DayPeriod;

public class Enemy extends Actor{
    public Enemy(Cell cell, DayPeriod dayPeriod) {
        super(cell, dayPeriod);
    }

    @Override
    public String getTileName() {
        return null;
    }
    public String getTileType(){
        return "enemy";
    }
}
