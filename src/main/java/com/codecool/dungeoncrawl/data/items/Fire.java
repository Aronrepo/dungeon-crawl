package com.codecool.dungeoncrawl.data.items;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.data.Item;

public class Fire extends Item {
    protected Cell cell;
    private static int turn = 0;

    private Cell dragon;
    public Fire(Cell cell) {
        this.cell = cell;
        this.cell.setItem(this);
    }

    public void move() {
        if(turn != 0 && turn < 7){
            Cell leftCell = cell.getNeighbor(0, -1);
            cell.setItem(null);
            leftCell.setItem(this);
            cell = leftCell;
        }else if(turn == 7){
            cell.setItem(null);
            cell.setType(CellType.GROUND);
            cell = dragon;
            turn = 0;
        }
        System.out.println(turn);
        turn += 1;
    }

    @Override
    public String getTileName() {
        return "fire";
    }

    public void setDragon(Cell dragon) {
        this.dragon = dragon;
    }
}
