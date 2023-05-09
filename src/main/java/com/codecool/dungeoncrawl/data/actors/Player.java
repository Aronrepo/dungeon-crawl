package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.DayPeriod;

import java.util.ArrayList;
import java.util.List;

public class Player extends Actor {
    private List<String> friendList = new ArrayList<>();

    public Player(Cell cell, DayPeriod dayPeriod) {
        super(cell, dayPeriod);
    }

    public String getTileName() {
        return "player";
    }

    public void addToFriends(Friend friend){
        friendList.add(friend.getTileName());
    }
    public List<String> getFriendList(){
        return friendList;
    }
}
