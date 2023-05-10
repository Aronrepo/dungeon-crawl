package com.codecool.dungeoncrawl.logic;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.DayPeriod;
import com.codecool.dungeoncrawl.data.GameMap;
import com.codecool.dungeoncrawl.data.actors.friend.Dragon;
import com.codecool.dungeoncrawl.data.items.Fire;

public class GameLogic {

    private GameMap map;

    private DayNightCycle cycle;


    public GameLogic(DayNightCycle cycle) {
        this.map = MapLoader.loadMap();
        this.cycle = cycle;
    }

    public double getMapWidth() {
        return map.getWidth();
    }

    public double getMapHeight() {
        return map.getHeight();
    }

    public void setup() {
    }

    public Cell getCell(int x, int y) {
        return map.getCell(x, y);
    }

    public String getPlayerHealth() {
        return Integer.toString(map.getPlayer().getHealth());
    }

    public String getPlayerPower() {
        return Integer.toString(map.getPlayer().getPower());
    }

    public GameMap getMap() {
        return map;
    }

    public void moveSkeletons() {
        map.moveSKeletons();
        map.getDragon().shootFire();
    }




    public void update() {
        cycle.timePassing();
        map.getPlayer().behaviourAtNight(cycle.getDayPeriod());
        map.getFiona().behaviourAtNight(cycle.getDayPeriod());

    }
}

