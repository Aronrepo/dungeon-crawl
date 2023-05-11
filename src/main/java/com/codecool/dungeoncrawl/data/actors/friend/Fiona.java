package com.codecool.dungeoncrawl.data.actors.friend;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.DayPeriod;
import com.codecool.dungeoncrawl.data.actors.AffectedByNight;
import com.codecool.dungeoncrawl.data.actors.Friend;

public class Fiona extends Friend implements AffectedByNight {

    public Fiona(Cell cell) {
        super(cell);
    }

    @Override
    public String getTileName() {
        return "fiona";
    }

    @Override
    public void behaviourAtNight(DayPeriod dayPeriod) {
        if (dayPeriod.equals(DayPeriod.NIGHT) && cell.getActor() != null && cell.getActor().getTileName().equals("fiona")) {
            cell.setActor(null);
        }
        if (dayPeriod.equals(DayPeriod.DAY)) {
            cell.setActor(this);
        }
    }
}
