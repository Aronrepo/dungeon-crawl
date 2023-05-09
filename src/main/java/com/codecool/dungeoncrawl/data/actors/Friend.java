package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.DayPeriod;
import com.codecool.dungeoncrawl.ui.elements.MainStage;

public class Friend extends Actor{
    public Friend(Cell cell, DayPeriod dayPeriod) {
        super(cell, dayPeriod);
    }

    @Override
    public String getTileName() {
        return null;
    }
    public String getActorType(){
        return "friend";
    }

    public void addToFriendList(Player player){
        player.addToFriends(this);
    }
}
