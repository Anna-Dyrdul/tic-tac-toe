package com.kodilla.tictactoe;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

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

        Button startGame = new Button("Start");
        startGame.setOnAction(e -> {
            TicTacToe gameOfUr = new TicTacToe();
            gameOfUr.startGame();
        });


        vBox.getChildren().addAll(title, startGame, showRules);

        Scene scene = new Scene(vBox, 250, 250, Color.WHITE);

        windowStart.setTitle("TicTacToe");
        windowStart.setScene(scene);
        windowStart.show();
    }

    private void closeProgram(){
        boolean answer = ConfirmBox.confirm();
        if(answer)
            windowStart.close();
    }
}
