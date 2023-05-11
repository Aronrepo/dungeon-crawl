package com.codecool.dungeoncrawl.data.items;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.data.Item;
import com.codecool.dungeoncrawl.data.actors.Player;

public class Fire extends Item {
    protected Cell cell;
    private static int turn = 0;
    private int hurtPlayer = 3;

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
        if(cell.getActor() instanceof Player){
            cell.getActor().setHealth(((Player) cell.getActor()).getHealth() - hurtPlayer);
        }
        turn += 1;
    }
    public Cell getCell(){
        return cell;
    }
    @Override
    public String getTileName() {
        return "fire";
    }

    public void setDragon(Cell dragon) {
        this.dragon = dragon;
    }
}
