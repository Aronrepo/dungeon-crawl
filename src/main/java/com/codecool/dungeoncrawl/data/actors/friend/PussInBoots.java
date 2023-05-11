package com.codecool.dungeoncrawl.data.actors.friend;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.actors.Friend;
import com.codecool.dungeoncrawl.data.actors.Player;

public class PussInBoots extends Friend {

    public PussInBoots(Cell cell) {
        super(cell);
    }

    @Override
    public String getTileName() {
        return "pussInBoots";
    }
}
