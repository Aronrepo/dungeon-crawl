package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;

public class Friend extends Actor{
    public Friend(Cell cell) {
        super(cell);
    }

    @Override
    public String getTileName() {
        return null;
    }
    public String getTileType(){
        return "friend";
    }
}
