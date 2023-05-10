package com.codecool.dungeoncrawl.data.actors.friend;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.actors.Friend;
import com.codecool.dungeoncrawl.data.items.Fire;

public class Dragon extends Friend {
    Fire storedFire;
    public Dragon(Cell cell) {
        super(cell);
    }

    @Override
    public String getTileName() {
        return "dragon";
    }

    public void getFire() {
        if(storedFire == null){
            storedFire = new Fire(cell.getNeighbor(0, -1));
        }
    }

    public void shootFire() {
        getFire();
        storedFire.setDragon(cell);
        storedFire.move();
    }
}
