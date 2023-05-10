package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.DayPeriod;

public interface AffectedByNight {
    public void behaviourAtNight(DayPeriod dayPeriod);
}
