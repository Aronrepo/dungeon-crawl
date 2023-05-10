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
    private Label friendText;
    private Label friendList;

    public StatusPane() {
        ui = new GridPane();
        dayTextLabel = new Label("Time of Day: ");
        dayValueLabel = new Label();
        healthTextLabel = new Label("Health: ");
        healthValueLabel = new Label();
        friendText = new Label("Friends : ");
        friendList = new Label("");
    }

    public BorderPane build() {

        ui.setPrefWidth(RIGHT_PANEL_WIDTH);
        ui.setPadding(new Insets(RIGHT_PANEL_PADDING));

        ui.add(dayTextLabel, 0, 0);
        ui.add(dayValueLabel, 1, 0);
        ui.add(healthTextLabel, 0, 1);
        ui.add(healthValueLabel, 1, 1);
        ui.add(friendText, 0, 2);
        ui.add(friendList, 1, 2);

        BorderPane borderPane = new BorderPane();
        borderPane.setRight(ui);
        return borderPane;
    }
    public void setFriendList(List<String> friends){
        friendList.setText(friends.toString().replace("[", "").replace("]", ""));
    }

    public void setHealthValue(String text) {
        healthValueLabel.setText(text);
    }
    public void setDayValue(String text) {
        dayValueLabel.setText(text);
    }
}
