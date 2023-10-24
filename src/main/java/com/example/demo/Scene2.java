package com.example.demo;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class Scene2 {

    private Scene scene;

    public Scene2(MainApp mainApp) {
        VBox layout = new VBox(30);
        layout.setStyle("-fx-padding: 20;");

        Button backButton = new Button("Back to Main Scene");
//        backButton.setOnAction(e -> mainApp.changeScene(new Initial(mainApp).getScene()));

        layout.getChildren().addAll(backButton);

        scene = new Scene(layout, 700, 550);
    }

    public Scene getScene() {
        return scene;
    }
}
