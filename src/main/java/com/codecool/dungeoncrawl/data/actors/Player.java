package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.DayPeriod;
import com.codecool.dungeoncrawl.logic.Attack;

import java.util.ArrayList;
import java.util.List;

public class Player extends Actor {

    private static int PLAYER_HEALTH = 10;
    private static final int PLAYER_POWER = 2;
    private List<String> friendList = new ArrayList<>();

    Attack attack = new Attack();

    public Player(Cell cell, DayPeriod dayPeriod) {
        super(cell, dayPeriod, PLAYER_HEALTH, PLAYER_POWER);
    }

    public String getTileName() {
        return "player";
    }

    public void move(int dx, int dy) {
            Cell nextCell = cell.getNeighbor(dx, dy);
        if(checkForLava(nextCell)){
          cell.getActor().setHealth(cell.getActor().getHealth() -3);
        }
        if (checkForWall(nextCell) && checkIfIsEmpty(nextCell)) {
            cell.setActor(null);
            nextCell.setActor(this);
            cell = nextCell;
        } else if (!checkIfIsEmpty(nextCell)) {
            if (checkEnemy(nextCell)) {
                boolean winner = attack.attack((Player) cell.getActor(), (Enemy) nextCell.getActor());
                if (winner) {
                    cell.setActor(null);
                    nextCell.setActor(this);
                    cell = nextCell;
                }
            } else if (checkIfFriend(nextCell)) {
                addToFriendList(nextCell);
                cell.setActor(null);
                nextCell.setActor(this);
                cell = nextCell;
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

    private void lavaHurts(Cell nextCell){

    }
    private boolean checkIfFriend(Cell nextCell) { return nextCell.getActor() instanceof Friend;}

    private void addToFriendList(Cell nextCell){
        Player player = (Player) cell.getActor();
        Friend friend = (Friend) nextCell.getActor();
        player.addToFriends(friend);
    }
}
