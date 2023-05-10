package com.codecool.dungeoncrawl.ui.elements;

import com.codecool.dungeoncrawl.data.actors.Friend;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;
import java.util.List;

public class StatusPane {
    public static final int RIGHT_PANEL_WIDTH = 200;
    public static final int RIGHT_PANEL_PADDING = 10;
    private GridPane ui;
    private Label dayTextLabel;
    private Label dayValueLabel;
    private Label healthTextLabel;
    private Label healthValueLabel;
    private Label powerTextLabel;
    private Label powerValueLabel;
    private Label friendText;
    private Label friendList;

    private Label itemText;
    private Label itemList;

    public StatusPane() {
        ui = new GridPane();
        dayTextLabel = new Label("Time of Day: ");
        dayValueLabel = new Label();
        healthTextLabel = new Label("Health: ");
        healthValueLabel = new Label();
        powerTextLabel = new Label("Power: ");
        powerValueLabel = new Label();
        friendText = new Label("Friends : ");
        friendList = new Label("");
        itemText = new Label("Items : ");
        itemList = new Label("");
    }

    public BorderPane build() {

        ui.setPrefWidth(RIGHT_PANEL_WIDTH);
        ui.setPadding(new Insets(RIGHT_PANEL_PADDING));

        ui.add(dayTextLabel, 0, 0);
        ui.add(dayValueLabel, 1, 0);
        ui.add(healthTextLabel, 0, 1);
        ui.add(healthValueLabel, 1, 1);
        ui.add(powerTextLabel, 0, 2);
        ui.add(powerValueLabel, 1, 2);
        ui.add(friendText, 0, 3);
        ui.add(friendList, 1, 3);
        ui.add(itemText, 2, 3);
        ui.add(itemList, 1, 4);

        BorderPane borderPane = new BorderPane();
        borderPane.setRight(ui);
        return borderPane;
    }

    public void setFriendList(List<String> friends){
        friendList.setText(friends.toString().replace("[", "").replace("]", ""));
    }

    public void setItemList(List<String> items){
        itemList.setText(items.toString().replace("[", "").replace("]", ""));
    }


    public void setDayValue(String text) {
        dayValueLabel.setText(text);
    }
    public void setHealthValue(String text) {
        healthValueLabel.setText(text);
    }
    public void setPowerValue(String text) {
        powerValueLabel.setText(text);
    }

}
