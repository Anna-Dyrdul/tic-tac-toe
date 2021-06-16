package com.kodilla.tictactoe;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.*;

public class StartApplication extends Application {

    private Stage windowStart;
    private TicTacToe ticTacToe = new TicTacToe();
    private File savedGame = new File("SavedGame.ser");
    private Ranking ranking = new Ranking();


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        windowStart = primaryStage;

        windowStart.setOnCloseRequest(e -> {
            e.consume();
            closeProgram();
        });

        VBox vBox = new VBox();
        vBox.setPadding(new Insets(10));
        vBox.setSpacing(10);
        vBox.setAlignment(Pos.CENTER);
        vBox.setBackground(new Background(new BackgroundFill(Color.BURLYWOOD, CornerRadii.EMPTY, Insets.EMPTY)));

        Label title = new Label("Tic Tac Toe");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 20));

        Button showRules = new Button("Show rules");
        showRules.setOnAction(e -> Rules.displayRules());

        Button chooseDifficulty = new Button("Chose difficulty");
        chooseDifficulty.setOnAction(e -> LevelOfDifficulty.chooseDifficulty());

        Button showRanking = new Button("Show ranking");
        showRanking.setOnAction(e -> {
            ranking.loadMap();
        });

        Button startNewGame = new Button("Start new game");
        startNewGame.setOnAction(e -> {
            ticTacToe = new TicTacToe();
            ticTacToe.startGame();
            saveGame();
        });

        Button continueGame = new Button("Continue");
        continueGame.setOnAction(e -> {
            loadGame();
            ticTacToe.startGame();
            saveGame();
        });

        vBox.getChildren().addAll(title, startNewGame, continueGame, showRules, chooseDifficulty, showRanking);
        Scene scene = new Scene(vBox, 250, 250, Color.WHITE);

        windowStart.setTitle("TicTacToe");
        windowStart.setScene(scene);
        windowStart.show();
    }

    private void closeProgram(){
        ranking.saveMap();
        boolean answer = ConfirmBox.confirm();
        if(answer)
            windowStart.close();
    }

    public void saveGame() {
        try {
            ObjectOutputStream oos = new ObjectOutputStream (new FileOutputStream(savedGame));
            oos.writeObject(ticTacToe);
            oos.close();
            System.out.println("Saved!");
        } catch (Exception e) {
            System.out.println("Oh no! Something went wrong! Error:" + e);
        }
    }

    public void loadGame() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(savedGame));
            Object readObject = ois.readObject();
            if(savedGame.length() != 0)
                ticTacToe =(TicTacToe) readObject;
            ois.close();
            System.out.println("Load");
        } catch (Exception e) {
            System.out.println("Oh no! Something went wrong! Error:" + e);
        }
    }

}
