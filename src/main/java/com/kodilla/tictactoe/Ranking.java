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

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Ranking {
    File savedHashMaps = new File("ranking.list");
    Map<Integer, String> map = new HashMap<>();
    TextArea rankingText = new TextArea();

    public void openWindow() {
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Ranking");
        window.setMinWidth(400);

        VBox layout = new VBox(10);
        layout.getChildren().add(rankingText);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(10,10,10,10));
        layout.setBackground(new Background(new BackgroundFill(Color.BURLYWOOD, CornerRadii.EMPTY, Insets.EMPTY)));


        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
    }

    // Zapis do pliku z rankingiem powinien następować po każdej zakończonej partii.
    public void saveMap() {
        map = CheckMove.sendMap();
        try {
            ObjectOutputStream oos = new ObjectOutputStream (new FileOutputStream(savedHashMaps));
            oos.writeObject(map);
            oos.close();
        } catch (Exception e) {
            System.out.println("Oh no! Something went wrong! Error:" + e);
        }
    }

    public void loadMap() {
        try {
            rankingText = new TextArea();
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(savedHashMaps));
            Object readMap = ois.readObject();
            if(readMap instanceof HashMap) {
                map.putAll((HashMap) readMap);
                System.out.println("Ranking");
                rankingText.setText(String.join("", map.values()));
                openWindow();
            }
            ois.close();
        } catch (Exception e) {
            System.out.println("Oh no! Something went wrong! Error:" + e);
        }
    }
}
