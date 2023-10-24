package demo;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Scene1 {
    private int state;
    private Scene scene;
    public Scene1(Main mainApp) {
        // Create UI components
        HBox buttonContainer = createButtonContainer(mainApp); // Create buttons for manipulation
        buttonContainer.setStyle("-fx-spacing: 5; -fx-alignment: CENTER;");

        // Create root layout
        BorderPane root = new BorderPane();
        root.setBottom(buttonContainer); // Add buttons to the bottom


        VBox layout = new VBox(30);
        layout.setStyle("-fx-padding: 20;");

//        layout.getChildren().addAll(backButton);
        scene = new Scene(root, 600, 450);
    }

    public Scene getScene() {
        return scene;
    }



    private HBox createButtonContainer(Main mainApp) {
        // Create buttons for manipulation
        Button prevButton = new Button("Previous");
        Button nextButton = new Button("Next");
        Button backButton = new Button("Back to Main Scene");

        backButton.setOnAction(event -> {
            mainApp.changeScene(new Initial(mainApp).getScene());
        });

        prevButton.setOnAction(event -> {
            // Handle Previous button action
            // updateMatrix(matrixGrid);
        });

        nextButton.setOnAction(event -> {
            // Handle Next button action
            // updateMatrix(matrixGrid);
        });

        // Create button container
        HBox buttonContainer = new HBox(prevButton, nextButton, backButton);
        buttonContainer.setAlignment(Pos.CENTER); // Center the buttons horizontally
        return buttonContainer;
    }

    private void updateMatrix(GridPane gridPane) {
        // Implement logic to update the matrix grid based on arrayManipulation state
        // You may need to get the current state of the array from your arrayManipulation object
        // and update the TextField values in the gridPane accordingly.
    }
}
