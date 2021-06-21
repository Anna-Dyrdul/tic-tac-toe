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
import java.util.Objects;

public class StartApplication extends Application {

    private Stage windowStart;

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
            ShowRanking.openWindow(Ranking.loadMap());
        });

        Button startNewGame = new Button("Start new game");
        startNewGame.setOnAction(e -> {
            TicTacToe ticTacToe = new TicTacToe();
            CheckMove.loadMap(Ranking.loadMap());
            ticTacToe.startGame(false);
        });


        Button continueGame = new Button("Continue");
        continueGame.setOnAction(e -> {
            TicTacToe ticTacToe = new TicTacToe();
            CheckMove.loadMap(Ranking.loadMap());
            ticTacToe.startGame(true);
        });

        vBox.getChildren().addAll(title, startNewGame, showRules, chooseDifficulty, showRanking, continueGame);
        Scene scene = new Scene(vBox, 250, 250, Color.WHITE);

        windowStart.setTitle("TicTacToe");
        windowStart.setScene(scene);
        windowStart.show();
    }

    private void closeProgram(){
        boolean answer = ConfirmBox.confirm();
        if(answer) {
            windowStart.close();
        }
    }



}
