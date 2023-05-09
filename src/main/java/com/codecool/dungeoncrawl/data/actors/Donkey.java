package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;

public class Donkey extends Actor{
    public Donkey(Cell cell) {
        super(cell);
    }

    @Override
    public String getTileName() {
        return "donkey";
    }
}
