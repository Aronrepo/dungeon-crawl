package com.codecool.dungeoncrawl.ui.elements;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class StatusPane {
    public static final int RIGHT_PANEL_WIDTH = 200;
    public static final int RIGHT_PANEL_PADDING = 10;
    private GridPane ui;
    private Label dayTextLabel;
    private Label dayValueLabel;
    private Label healthTextLabel;
    private Label healthValueLabel;

    public StatusPane() {
        ui = new GridPane();
        dayTextLabel = new Label("Time of Day: ");
        dayValueLabel = new Label();
        healthTextLabel = new Label("Health: ");
        healthValueLabel = new Label();
    }

    public BorderPane build() {

        ui.setPrefWidth(RIGHT_PANEL_WIDTH);
        ui.setPadding(new Insets(RIGHT_PANEL_PADDING));

        ui.add(dayTextLabel, 0, 0);
        ui.add(dayValueLabel, 1, 0);
        ui.add(healthTextLabel, 0, 1);
        ui.add(healthValueLabel, 1, 1);

        BorderPane borderPane = new BorderPane();
        borderPane.setRight(ui);
        return borderPane;
    }

    public void setHealthValue(String text) {
        healthValueLabel.setText(text);
    }
    public void setDayValue(String text) {
        dayValueLabel.setText(text);
    }
}
