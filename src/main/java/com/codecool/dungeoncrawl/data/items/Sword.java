package com.codecool.dungeoncrawl.data.items;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.Drawable;
import com.codecool.dungeoncrawl.data.Item;

public class Sword extends Item {

    private final int swordPower = 3;


    protected Cell cell;

    public Sword(Cell cell){
        this.cell = cell;
        this.cell.setItem(this);
    }

    public int getSwordPower() {
        return swordPower;
    }

    @Override
    public String getTileName() {
        return "sword";
    }
}
