package com.codecool.dungeoncrawl.data.actors.friend;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.actors.Friend;

public class Fiona extends Friend {

    public Fiona(Cell cell) {
        super(cell);
    }

    @Override
    public String getTileName() {
        return "fiona";
    }
}
