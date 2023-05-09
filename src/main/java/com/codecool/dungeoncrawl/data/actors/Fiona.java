package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;

public class Fiona extends Actor{

    public Fiona(Cell cell) {
        super(cell);
    }

    @Override
    public String getTileName() {
        return "fiona";
    }
}
