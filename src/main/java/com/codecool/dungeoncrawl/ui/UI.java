package com.codecool.dungeoncrawl.ui;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.logic.DayNightCycle;
import com.codecool.dungeoncrawl.data.actors.Player;
import com.codecool.dungeoncrawl.logic.GameLogic;
import com.codecool.dungeoncrawl.ui.elements.MainStage;
import com.codecool.dungeoncrawl.ui.keyeventhandler.KeyHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Set;

public class UI {
    private Canvas canvas;
    private GraphicsContext context;

    private MainStage mainStage;
    private GameLogic logic;
    private Set<KeyHandler> keyHandlers;
    private DayNightCycle dayNightCycle;


    public UI(GameLogic logic, Set<KeyHandler> keyHandlers, DayNightCycle dayNightCycle) {
        this.canvas = new Canvas(
                logic.getMapWidth() * Tiles.TILE_WIDTH,
                logic.getMapHeight() * Tiles.TILE_WIDTH);
        this.logic = logic;
        this.context = canvas.getGraphicsContext2D();
        this.mainStage = new MainStage(canvas);
        this.keyHandlers = keyHandlers;
        this.dayNightCycle = dayNightCycle;
    }

    public void setUpPain(Stage primaryStage) {
        Scene scene = mainStage.getScene();
        primaryStage.setScene(scene);
        logic.setup();
        refresh();
        scene.setOnKeyPressed(this::onKeyPressed);
    }

    private void onKeyPressed(KeyEvent keyEvent) {
        for (KeyHandler keyHandler : keyHandlers) {
            keyHandler.perform(keyEvent, logic.getMap());
        }

        logic.update();
        refresh();
    }

    public void refresh() {
        context.setFill(Color.BLACK);
            context.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
            boolean isTherePlayer = false;
            for (int x = 0; x < logic.getMapWidth(); x++) {
                for (int y = 0; y < logic.getMapHeight(); y++) {
                    Cell cell = logic.getCell(x, y);
                    if (cell.getActor() != null) {
                        Tiles.drawTile(context, cell.getActor(), x, y, dayNightCycle.getDayPeriod());
                        if (cell.getActor().getTileName().equals("player")) {
                            Player player = (Player) cell.getActor();
                            mainStage.setHealthLabelText(logic.getPlayerHealth());
                            mainStage.setPowerLabelText(logic.getPlayerPower());
                            mainStage.addFriend(player.getFriendList());
                            mainStage.addItem(player.getItemList());
                            isTherePlayer = true;
                        }
                    } else if (cell.getItem() != null) {
                        Tiles.drawTile(context, cell.getItem(), x, y, dayNightCycle.getDayPeriod());
                    } else {
                        Tiles.drawTile(context, cell, x, y, dayNightCycle.getDayPeriod());
                    }
                }
                mainStage.setDayLabelText(dayNightCycle.getDayPeriod().toString());
                if (!isTherePlayer) {
                    mainStage.setHealthLabelText("0");
                }
            }
        }
}
