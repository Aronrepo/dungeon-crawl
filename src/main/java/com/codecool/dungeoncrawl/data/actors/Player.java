package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.DayPeriod;
import com.codecool.dungeoncrawl.data.Item;
import com.codecool.dungeoncrawl.logic.Attack;

import java.util.ArrayList;
import java.util.List;

public class Player extends Actor implements AffectedByNight{

    private static int PLAYER_STARTER_HEALTH = 10;
    private static final int PLAYER_STARTER_POWER = 2;
    private int currentHP = PLAYER_STARTER_HEALTH;
    private int currentAD = PLAYER_STARTER_POWER;
    private List<String> friendList = new ArrayList<>();

    private List<String> itemList = new ArrayList<>();

    Attack attack = new Attack();

    public Player(Cell cell) {
        super(cell, PLAYER_STARTER_HEALTH, PLAYER_STARTER_POWER);
    }

    public String getTileName() {
        return "player";
    }

    @Override
    public int getHealth() {
        return currentHP;
    }

    @Override
    public void setHealth(int changeHealth) {
        currentHP = changeHealth;
    }

    @Override
    public int getPower() {
        return currentAD;
    }

    private void updatePower(DayPeriod dayPeriod) {
        int power = powerDuringDay();
        if (dayPeriod.equals(DayPeriod.DAY)) {
            currentAD = power;
        }
        else {
            currentAD = power * 10;
        }
    }

    private int powerDuringDay() {
        int power = 0;
        if (itemList.contains("sword")){
            power += 2;
        }
        return PLAYER_STARTER_POWER + power;
    }

    public void move(int dx, int dy) {
            Cell nextCell = cell.getNeighbor(dx, dy);
        if(checkForLava(nextCell)){
          cell.getActor().setHealth(cell.getActor().getHealth() -3);
        }
        if (checkForWall(nextCell) && checkIfIsEmpty(nextCell) && !checkIfItem(nextCell)) {
            cell.setActor(null);
            nextCell.setActor(this);
            cell = nextCell;
        } else if (!checkIfIsEmpty(nextCell) || checkIfItem(nextCell)) {
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
            } else if (checkIfItem(nextCell)) {
                addToItemList(nextCell);
                nextCell.setItem(null);
                cell.setActor(null);
                nextCell.setActor(this);
                cell = nextCell;
            }
        }

    }

    public void addToFriends(Friend friend){
        friendList.add(friend.getTileName());
        currentHP = currentHP + 5;
    }
    public List<String> getFriendList(){
        return friendList;
    }

    public List<String> getItemList(){
        return itemList;
    }

    private boolean checkEnemy(Cell nextCell) {
        return nextCell.getActor() instanceof Enemy;
    }

    private void lavaHurts(Cell nextCell){

    }
    private boolean checkIfFriend(Cell nextCell) { return nextCell.getActor() instanceof Friend;}

    private boolean checkIfItem(Cell nextCell) { return nextCell.getItem() instanceof Item;}

    public void addToItems(Item item) {
        itemList.add(item.getTileName());
    }


    private void addToFriendList(Cell nextCell){
        Player player = (Player) cell.getActor();
        Friend friend = (Friend) nextCell.getActor();
        player.addToFriends(friend);
    }

    private void addToItemList(Cell nextCell) {
        Player player = (Player) cell.getActor();
        Item item = nextCell.getItem();
        player.addToItems(item);
    }

    @Override
    public void behaviourAtNight(DayPeriod dayPeriod) {
        updatePower(dayPeriod);
    }
}
