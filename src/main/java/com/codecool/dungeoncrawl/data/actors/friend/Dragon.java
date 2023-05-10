package com.codecool.dungeoncrawl.data.actors.friend;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.actors.Friend;

public class Dragon extends Friend {
    public Dragon(Cell cell) {
        super(cell);
    }

    @Override
    public String getTileName() {
        return "dragon";
    }
}
