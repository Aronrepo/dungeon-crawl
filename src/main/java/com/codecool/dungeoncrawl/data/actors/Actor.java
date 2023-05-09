package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.data.DayPeriod;
import com.codecool.dungeoncrawl.data.Drawable;

public abstract class Actor implements Drawable {

    protected Cell cell;
    private DayPeriod dayPeriod;
    private int health = 10;

    public Actor(Cell cell, DayPeriod dayPeriod) {

        this.cell = cell;
        this.dayPeriod = dayPeriod;
        this.cell.setActor(this);
    }




        Cell nextCell = cell.getNeighbor(dx, dy);
        if (checkForWall(nextCell)) {
            cell.setActor(null);
            nextCell.setActor(this);
            cell = nextCell;
        } else if (!checkIfIsEmpty(nextCell)) {
            if (checkEnemy(nextCell)) {
                attack(nextCell);
            } else if (checkIfFriend(nextCell)) {
               addToFriendList(nextCell);
            }
        }

    }

    private void addToFriendList(Cell nextCell){
        Player player = (Player) cell.getActor();
        Friend friend = (Friend) nextCell.getActor();
        player.addToFriends(friend);
        cell.setType(null);
        nextCell.setActor(this);
    }

    private boolean checkIfFriend(Cell nextCell) {
        return nextCell.getActor().getTileName().equals("friend");
    }


    private boolean checkIfIsEmpty(Cell nextCell) {
        return nextCell.getActor() == null;
    }



    private void attack(Cell nextCell) {

        setHealth(getHealth()-2);

    }

    public int getHealth() {
        return health;
    }


    public void setHealth(int health) {
        this.health = health;
    }


    public Cell getCell() {
        return cell;
    }

    public int getX() {
        return cell.getX();
    }

    public int getY() {
        return cell.getY();
    }
}
