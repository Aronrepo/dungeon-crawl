package com.codecool.dungeoncrawl.ui.keyeventhandler;

import com.codecool.dungeoncrawl.data.GameMap;
import com.codecool.dungeoncrawl.data.actors.Actor;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Down implements KeyHandler {
    public static final KeyCode code = KeyCode.DOWN;

    @Override
    public void perform(KeyEvent event, GameMap map) {
        Actor player = map.getPlayer();
        if (code.equals(event.getCode()) && !player.checkTile(0, 1).equals("wall"))
            map.getPlayer().move(0, 1);
    }
}
