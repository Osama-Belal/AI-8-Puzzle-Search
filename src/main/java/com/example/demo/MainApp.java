package com.example.demo;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {

    private Stage primaryStage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        primaryStage.setTitle("8-Puzzle Solver");

        Initial mainScene = new Initial(this);
        primaryStage.setScene(mainScene.getScene());
        primaryStage.show();
    }

    public void changeScene(Scene scene) {
        primaryStage.setScene(scene);
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }
}
