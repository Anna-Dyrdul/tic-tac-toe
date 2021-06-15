package com.kodilla.tictactoe;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Inform {

    public static void endGame(String result) {
        Stage windowEndGame = new Stage();
        windowEndGame.initModality(Modality.APPLICATION_MODAL);
        windowEndGame.setTitle("EndGame");
        windowEndGame.setMinWidth(200);
        windowEndGame.setMinHeight(200);

        Label label = new Label();
        label.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        label.setText(result);

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label);
        layout.setAlignment(Pos.CENTER);
        layout.setBackground(new Background(new BackgroundFill(Color.BURLYWOOD, CornerRadii.EMPTY, Insets.EMPTY)));

        Scene scene = new Scene(layout);

        windowEndGame.setScene(scene);
        windowEndGame.show();
    }

}
