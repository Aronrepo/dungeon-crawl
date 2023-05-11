package com.codecool.dungeoncrawl.data.actors.enemy;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.actors.Enemy;

import java.util.ArrayList;
import java.util.List;

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
            if(checkSurroundingCells()){
                cell.setActor(null);
                rightCell.setActor(this);
                cell = rightCell;
            }
            //checkPlayer(rightCell);
        } else {
            Cell leftCell = cell.getNeighbor(-1,0);
            if(checkSurroundingCells()){
                cell.setActor(null);
                leftCell.setActor(this);
                cell = leftCell;
            }
        }
        turnNum += 1;
    }

    private boolean checkSurroundingCells() {
        List<Cell> surroundingCells = new ArrayList<>();
        surroundingCells.add(cell.getNeighbor(1, 0));
        surroundingCells.add(cell.getNeighbor(-1, 0));
        surroundingCells.add(cell.getNeighbor(0, 1));
        surroundingCells.add(cell.getNeighbor(0, -1));
        for (Cell sourroundingCell : surroundingCells) {
            if (checkPlayer(sourroundingCell)) {
                return false;
            }

        }
        return true;
    }
}
