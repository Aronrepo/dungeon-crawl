package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.DayPeriod;

import java.util.ArrayList;
import java.util.List;

public class Player extends Actor {

    private int power = 2;
    private List<String> friendList = new ArrayList<>();

    public Player(Cell cell, DayPeriod dayPeriod) {
        super(cell, dayPeriod);
    }

    public String getTileName() {
        return "player";
    }

    public void move(int dx, int dy) {

        Cell nextCell = cell.getNeighbor(dx, dy);
        if (checkForWall(nextCell) && checkIfIsEmpty(nextCell)) {
            cell.setActor(null);
            nextCell.setActor(this);
            cell = nextCell;
        } else if (!checkIfIsEmpty(nextCell)) {
            if (checkEnemy(nextCell)) {
                System.out.println("attack");
            } else if (checkIfFriend(nextCell)) {
                addToFriendList(nextCell);
            }
        }

    }

    public void addToFriends(Friend friend){
        friendList.add(friend.getTileName());
    }
    public List<String> getFriendList(){
        return friendList;
    }

    private boolean checkEnemy(Cell nextCell) {
        return nextCell.getActor() instanceof Enemy;
    }

    private boolean checkIfFriend(Cell nextCell) { return nextCell.getActor() instanceof Friend;}

    private void addToFriendList(Cell nextCell){
        Player player = (Player) cell.getActor();
        Friend friend = (Friend) nextCell.getActor();
        player.addToFriends(friend);
        cell.setType(null);
        nextCell.setActor(this);
    }
}
