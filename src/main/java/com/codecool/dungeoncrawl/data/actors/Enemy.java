package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;

public class Enemy extends Actor{
    public Enemy(Cell cell) {
        super(cell);
    }

    @Override
    public String getTileName() {
        return null;
    }
    public String getTileType(){
        return "enemy";
    }
}
