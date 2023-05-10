package com.codecool.dungeoncrawl.logic;

import com.codecool.dungeoncrawl.data.actors.Actor;
import com.codecool.dungeoncrawl.data.actors.Enemy;
import com.codecool.dungeoncrawl.data.actors.Player;

public class Attack {


    public boolean attack(Player player, Enemy enemy) {
        player.setHealth(player.getHealth() - enemy.getPower());
        enemy.setHealth(enemy.getHealth() - player.getPower());
        if(player.getHealth() <= 0) {
            System.out.println("You loose!");
        }
        if(enemy.getHealth() <= 0){
            return true;
        }
        return false;
    }
}
