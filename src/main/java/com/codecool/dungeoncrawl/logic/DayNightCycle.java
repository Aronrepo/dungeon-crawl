package com.codecool.dungeoncrawl.logic;

import com.codecool.dungeoncrawl.data.DayPeriod;

public class DayNightCycle {
    private int currentTime = 0;
    private DayPeriod currentDayPeriod = DayPeriod.DAY;
    public void timePassing() {
        currentTime += 1;
        if (currentTime == 6) {
            currentTime = 1;
            setDayPeriod();
        }
    }
    private void setDayPeriod() {
        if(currentDayPeriod.equals(DayPeriod.DAY)) {
            currentDayPeriod = DayPeriod.NIGHT;
        }
        else {
            currentDayPeriod = DayPeriod.DAY;
        }
    }
    public DayPeriod getDayPeriod() {return currentDayPeriod;}
}
