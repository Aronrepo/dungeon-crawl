package com.codecool.dungeoncrawl.ui.keyeventhandler;

import com.codecool.dungeoncrawl.data.GameMap;
import com.codecool.dungeoncrawl.data.actors.Actor;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Left implements KeyHandler {
    public static final KeyCode code = KeyCode.LEFT;

    @Override
    public void perform(KeyEvent event, GameMap map) {
        Actor player = map.getPlayer();
        if(code.equals(event.getCode()) && !player.checkTile(-1, 0).equals("wall"))
            player.move(-1, 0);

    }
}
