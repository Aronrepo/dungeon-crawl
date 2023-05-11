package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.ui.elements.MainStage;

public class Friend extends Actor{

    private static final int PLAYER_HEALTH = 1;
    private static final int PLAYER_POWER = 1;
    public Friend(Cell cell) {
        super(cell, PLAYER_HEALTH, PLAYER_POWER);
    }

    @Override
    public String getTileName() {
        return null;
    }

    public String getActorType(){
        return "friend";
    }
}
