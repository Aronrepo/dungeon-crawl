package com.codecool.dungeoncrawl.data;

public class Item implements Drawable{

    DayPeriod dayPeriod;

    protected Cell cell;

    public Item(Cell cell, DayPeriod dayPeriod){
        this.cell = cell;
        this.dayPeriod = dayPeriod;
        this.cell.setItem(this);
    }

    @Override
    public String getTileName() {
        return "sword";
    }
}
