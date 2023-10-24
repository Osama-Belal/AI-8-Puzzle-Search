package com.example.demo;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class MatrixPreview {
    private final Scene scene;
    private int currentStateIndex;
    private final long[] pathOfStates;

    public MatrixPreview(MainApp mainApp, ArrayList<Long> path) {
        VBox layout = new VBox(30);
        layout.setStyle("-fx-background-color: #DAFFFB; -fx-padding: 20; -fx-alignment: center;");

        // Convert the ArrayList to an array of longs
        this.pathOfStates = path.stream().mapToLong(Long::longValue).toArray();
        this.currentStateIndex = 0;

        // Create UI components
        GridPane matrixGrid = createMatrixGrid(this.pathOfStates[0]); // Create a 3x3 matrix grid
        HBox buttonContainer = createButtonContainer(matrixGrid, mainApp); // Create buttons for manipulation

        // Apply styles directly to components
        matrixGrid.setStyle("-fx-background-color: #DAFFFB;");
        buttonContainer.setStyle("-fx-text-fill: #FFF; -fx-alignment: center;-fx-font-size: 15;");

        // Create root layout
        BorderPane root = new BorderPane();
        root.setCenter(matrixGrid); // Add the matrix grid to the center
        root.setBottom(buttonContainer); // Add buttons to the bottom

        // Update UI initially
        updateMatrix(matrixGrid, this.pathOfStates[0]);

        layout.getChildren().addAll(matrixGrid, buttonContainer);
        scene = new Scene(layout, 700, 550);
    }

    public Scene getScene() { return scene; }

    private GridPane createMatrixGrid(long state) {
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(5);
        gridPane.setVgap(5);

        // Populate the grid with TextField inputs (you can replace this with your actual input logic)
        for (int row = 2; row >= 0; row--) {
            for (int col = 2; col >= 0; col--) {
                TextField textField = new TextField();
                textField.setStyle("-fx-background-color: #176B87;-fx-border-width: 0;" +
                        "-fx-border-radius: 0; -fx-text-fill: #FFF;-fx-alignment: CENTER; -fx-font-size:30");
                textField.setMinSize(100,100);
                textField.setMaxSize(200, 200);
                // get the right most digit
                int val = (int) state % 10;
                state /= 10;

                // Set initial values (you can replace this with your logic)
                textField.setText(String.valueOf(val));

                gridPane.add(textField, col, row);
            }
        }

        return gridPane;
    }

    private HBox createButtonContainer(GridPane matrixGrid, MainApp mainApp) {
        // Create Previous and Next buttons and handle their actions
        Button prevButton = new Button("Previous");
        Button nextButton = new Button("Next");
        Button backButton = new Button("Back to Main Scene");
        prevButton.setStyle("-fx-background-color: #04364A;-fx-text-fill: #FFF;" +
                "-fx-alignment: center;-fx-font-size: 15;");
        prevButton.setMinSize(150, 50);
        prevButton.setMaxSize(150, 50);
        nextButton.setStyle("-fx-background-color: #04364A;-fx-text-fill: #FFF;" +
                "-fx-alignment: center;-fx-font-size: 15;");
        nextButton.setMinSize(150, 50);
        nextButton.setMaxSize(150, 50);
        backButton.setStyle("-fx-background-color: #04364A;-fx-text-fill: #FFF;" +
                "-fx-alignment: center;-fx-font-size: 15;");
        backButton.setMinSize(150, 50);
        backButton.setMaxSize(150, 50);

        backButton.setOnAction(event -> {
            mainApp.changeScene(new Initial(mainApp).getScene());
        });

        prevButton.setOnAction(event -> {
            // Handle Previous button action
            if (currentStateIndex > 0) {
                currentStateIndex--;
                updateMatrix(matrixGrid, pathOfStates[currentStateIndex]);
            }
        });

        nextButton.setOnAction(event -> {
            // Handle Next button action
            if (currentStateIndex < pathOfStates.length - 1) {
                currentStateIndex++;
                updateMatrix(matrixGrid, pathOfStates[currentStateIndex]);
            }
        });

        // Create button container (HBox) and center the buttons
        HBox buttonContainer = new HBox(prevButton, nextButton, backButton);
        buttonContainer.setAlignment(Pos.CENTER);
        buttonContainer.setSpacing(5);
        return buttonContainer;
    }

    private void updateMatrix(GridPane matrix, long state) {
        for (int row = 0, col = 0;row*3 + col < 9;col++) {
            // Move to the next row if the current column exceeds 2
            row += col / 3;
            col = col % 3;

            // Update the TextField at the current row and column with the corresponding value
            TextField textField = (TextField) matrix.getChildren().get(row * 3 + col);
            textField.setText(String.valueOf(state % 10));
            if((state % 10) == 0) {textField.setText("");}
            state /= 10;
        }
    }

}
