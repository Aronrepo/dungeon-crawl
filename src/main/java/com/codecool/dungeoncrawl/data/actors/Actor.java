package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.data.DayPeriod;
import com.codecool.dungeoncrawl.data.Drawable;

public abstract class Actor implements Drawable {
    private Cell cell;
    private DayPeriod dayPeriod;
    private int health = 10;

    public Actor(Cell cell, DayPeriod dayPeriod) {
        this.cell = cell;
        this.dayPeriod = dayPeriod;
        this.cell.setActor(this);
    }

    public void move(int dx, int dy) {

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

    private boolean checkForWall(Cell nextCell) {
        return !nextCell.getType().equals(CellType.WALL);
    }

    private void attack(Cell nextCell) {
        nextCell.getActor();
    }

    private boolean checkEnemy(Cell nextCell) {
        return nextCell.getType().getTileName().equals("enemy");
    }

    public int getHealth() {
        return health;
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
