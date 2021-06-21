package com.kodilla.tictactoe;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.util.Map;

public class ShowRanking {
    private static final TextArea rankingText = new TextArea();

    public static void openWindow(Map<Long, String> map) {
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Ranking");
        window.setMinWidth(400);

        VBox layout = new VBox(10);
        layout.getChildren().add(rankingText);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(10,10,10,10));
        layout.setBackground(new Background(new BackgroundFill(Color.BURLYWOOD, CornerRadii.EMPTY, Insets.EMPTY)));

        rankingText.setText(String.join("", map.values()));

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
    }



}
