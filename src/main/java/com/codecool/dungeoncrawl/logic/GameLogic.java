package com.codecool.dungeoncrawl.logic;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.DayPeriod;
import com.codecool.dungeoncrawl.data.GameMap;

public class GameLogic {
    private GameMap map;

    public GameLogic(DayPeriod dayPeriod) {
        this.map = MapLoader.loadMap(dayPeriod);
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
}
