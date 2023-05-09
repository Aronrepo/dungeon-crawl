package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;

public class Farquad extends Actor{
    public Farquad(Cell cell) {
        super(cell);
    }

    @Override
    public String getTileName() {
        return "farquad";
    }
}
