package com.kodilla.tictactoe;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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

public class LevelOfDifficulty {
    private static int levelOfDifficulty;

    public static void chooseDifficulty(){
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setMinWidth(250);
        window.setMinHeight(250);

        Label label = new Label("Choose level of difficulty");
        label.setFont(Font.font("Arial", FontWeight.BOLD, 20));

        VBox layout = new VBox(10);

        Button levelOne = new Button("Level 1");
        levelOne.setOnAction(e -> {
            levelOfDifficulty = 1;
            ComputerMove.loadDifficulty(levelOfDifficulty);
            window.close();
        });

        Button levelTwo = new Button("Level 2");
        levelTwo.setOnAction(e -> {
            levelOfDifficulty = 2;
            ComputerMove.loadDifficulty(levelOfDifficulty);
            window.close();
        });


        layout.getChildren().addAll(label, levelOne, levelTwo);
        layout.setAlignment(Pos.CENTER);
        layout.setBackground(new Background(new BackgroundFill(Color.BURLYWOOD, CornerRadii.EMPTY, Insets.EMPTY)));

        Scene scene = new Scene(layout);
        window.setTitle("Level Of Difficulty");
        window.setScene(scene);
        window.show();
    }
}
