package com.codecool.dungeoncrawl.data.actors.enemy;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.actors.Enemy;

public class Skeleton extends Enemy {

    private static final int SKELETON_HEALTH = 1;
    private static final int SKELETON_POWER = 1;
    public Skeleton(Cell cell) {
        super(cell, SKELETON_HEALTH, SKELETON_POWER);
    }

    @Override
    public String getTileName() {
        return "skeleton";
    }
}
