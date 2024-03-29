package com.codecool.dungeoncrawl.ui.elements;

import com.codecool.dungeoncrawl.data.actors.Friend;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.BorderPane;

import java.util.List;

public class MainStage {
    private Canvas canvas;
    private Scene scene;
    private StatusPane statusPane;

    public MainStage(Canvas canvas) {
        this.canvas = canvas;
        statusPane = new StatusPane();
        scene = setUpScene();
    }

    private Scene setUpScene() {
        BorderPane borderPane = statusPane.build();
        borderPane.setCenter(canvas);
        Scene scene = new Scene(borderPane);
        return scene;
    }

    public Scene getScene() {
        return scene;
    }

    public void setDayLabelText(String text) {
        this.statusPane.setDayValue(text);
    }
    public void setHealthLabelText(String text) {
        this.statusPane.setHealthValue(text);
    }
    public void setPowerLabelText(String text) {
        this.statusPane.setPowerValue(text);
    }
    public void addFriend(List<String> friends){
        this.statusPane.setFriendList(friends);
    }
    public void addItem(List<String> items){
        this.statusPane.setItemList(items);
    }
}
