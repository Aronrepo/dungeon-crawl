package com.codecool.dungeoncrawl.data;

public class Item implements Drawable{


    protected Cell cell;

    public Item(Cell cell){
        this.cell = cell;
        this.cell.setItem(this);
    }

    @Override
    public String getTileName() {
        return "sword";
    }
}
