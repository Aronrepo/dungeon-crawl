package com.codecool.dungeoncrawl.data.items;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.Drawable;
import com.codecool.dungeoncrawl.data.Item;

public class Sword extends Item {


    protected Cell cell;

    public Sword(Cell cell){
        this.cell = cell;
        this.cell.setItem(this);
    }

    @Override
    public String getTileName() {
        return "sword";
    }
}
