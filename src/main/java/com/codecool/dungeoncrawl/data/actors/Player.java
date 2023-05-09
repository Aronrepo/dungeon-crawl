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

    public void move(int dx, int dy) {

        Cell nextCell = cell.getNeighbor(dx, dy);
        if (checkForWall(nextCell) && !checkEnemy(nextCell)) {
            cell.setActor(null);
            nextCell.setActor(this);
            cell = nextCell;
        }

    }

    private boolean checkEnemy(Cell cell) {
        return cell.getActor() instanceof Enemy;
    }

    public String getTileName() {
        return "player";
    }


    private boolean checkForWall(Cell nextCell){
        return !nextCell.getType().equals(CellType.WALL);

    public void addToFriends(Friend friend){
        friendList.add(friend.getTileName());
    }
    public List<String> getFriendList(){
        return friendList;

    }
}
