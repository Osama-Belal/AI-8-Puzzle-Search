package demo;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class Scene2 {

    private Scene scene;

    public Scene2(Main mainApp) {
        VBox layout = new VBox(20);
        layout.setStyle("-fx-padding: 20;");

        Button backButton = new Button("Back to Main Scene");
        backButton.setOnAction(e -> mainApp.changeScene(new Initial(mainApp).getScene()));

        layout.getChildren().addAll(backButton);

        scene = new Scene(layout, 300, 200);
    }

    public Scene getScene() {
        return scene;
    }
}
