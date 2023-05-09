package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;

public class PussInBoots extends Actor{

    public PussInBoots(Cell cell) {
        super(cell);
    }

    @Override
    public String getTileName() {
        return "pussInBoots";
    }
}
