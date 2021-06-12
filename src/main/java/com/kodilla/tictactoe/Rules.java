package com.kodilla.tictactoe;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Rules {
    public static void displayRules(){
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Rules");
        window.setMinWidth(300);

        ClassLoader classLoader = Rules.class.getClassLoader();
        File file = new File(classLoader.getResource("rules.txt").getFile());


        TextArea rules = new TextArea();
        try(Stream<String> fileLines = Files.lines(Paths.get(file.getPath()))){
            rules.setText(fileLines.collect(Collectors.joining("\n")));
            rules.setEditable(false);
            rules.setWrapText(true);
            rules.setMinHeight(250);
        } catch (Exception e) {
            System.out.println("Oh no! Something went wrong! Error:" + e);
        }


        Button closeButton = new Button("Understood");
        closeButton.setOnAction(e -> window.close());

        VBox layout = new VBox(10);
        layout.getChildren().addAll(rules, closeButton);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(10,10,10,10));
        layout.setBackground(new Background(new BackgroundFill(Color.BURLYWOOD, CornerRadii.EMPTY, Insets.EMPTY)));

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
    }
}
