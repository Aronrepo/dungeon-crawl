package com.codecool.dungeoncrawl.data.actors.enemy;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.actors.Enemy;

public class Skeleton extends Enemy {

    private static final int SKELETON_HEALTH = 1;
    private static final int SKELETON_POWER = 1;

    private int turnNum = 0;
  
    public Skeleton(Cell cell) {
        super(cell, SKELETON_HEALTH, SKELETON_POWER);

    }

    @Override
    public String getTileName() {
        return "skeleton";
    }

    public void move(){
        if(turnNum % 2 == 0){
            Cell rightCell = cell.getNeighbor(1,0);
            cell.setActor(null);
            rightCell.setActor(this);
            cell = rightCell;
        } else {
            Cell leftCell = cell.getNeighbor(-1,0);
            cell.setActor(null);
            leftCell.setActor(this);
            cell = leftCell;
        }
        turnNum += 1;
    }
}
