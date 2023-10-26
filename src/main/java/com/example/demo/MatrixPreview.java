package com.example.demo;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Bounds;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.SVGPath;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.util.Duration;

import java.util.ArrayList;

public class MatrixPreview {
    private final Scene scene;
    private int currentStateIndex;
    private final long[] pathOfStates;
    private int nodesExpanded;
    private int depth;
    private int costToReach;
    private long runningTime;


    public MatrixPreview(MainApp mainApp, ArrayList<Long> path, int nodesExpanded, int depth, int costToReach, long runningTime) {
        VBox layout = new VBox(30);
        layout.setStyle("-fx-background-color: #BEF2FF; -fx-padding: 20; -fx-alignment: center;");

        // Convert the ArrayList to an array of longs
        this.pathOfStates = path.stream().mapToLong(Long::longValue).toArray();
        this.currentStateIndex = 0;
        this.nodesExpanded = nodesExpanded;
        this.depth = depth;
        this.costToReach = costToReach;
        this.runningTime = runningTime;

        // Create UI components
        GridPane matrixGrid = createMatrixGrid(this.pathOfStates[0]); // Create a 3x3 matrix grid
        HBox buttonContainer = createTraverseButtonContainer(matrixGrid); // Create buttons for manipulation
        HBox buttonStatsContainer = createActionButtonContainer(mainApp);

        // Apply styles directly to components
        matrixGrid.setStyle("-fx-background-color: #BEF2FF;");
        buttonContainer.setStyle("-fx-text-fill: #FFF; -fx-alignment: center;-fx-font-size: 15;");
        buttonStatsContainer.setStyle("-fx-text-fill: #FFF; -fx-alignment: center;-fx-font-size: 15;");

        // Create root layout
        BorderPane root = new BorderPane();
        root.setCenter(matrixGrid); // Add the matrix grid to the center
        root.setBottom(buttonContainer); // Add buttons to the bottom
        root.setRight(buttonStatsContainer);

        // Update UI initially
        updateMatrix(matrixGrid, this.pathOfStates[0]);

        layout.getChildren().addAll(matrixGrid, buttonContainer, buttonStatsContainer);
        scene = new Scene(layout, 1024, 768);
    }

    public Scene getScene() { return scene; }
    private GridPane createMatrixGrid(long state) {
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        // Populate the grid with TextField inputs (you can replace this with your actual input logic)
        for (int row = 2; row >= 0; row--) {
            for (int col = 2; col >= 0; col--) {
                TextField textField = new TextField();
                textField.setDisable(true);
                textField.setStyle("-fx-text-fill: #FFF;-fx-alignment: CENTER; -fx-font-size:30");
                textField.setMinSize(150,150);
                textField.setMaxSize(200, 200);

                // get the right most digit
                int val = (int) state % 10;
                state /= 10;

                if((state % 10) == 0) {
                    textField.setText("");
                    textField.setStyle("-fx-background-color: #BEF2FF;-fx-border-width: 0;" +
                            "-fx-border-radius: 0; -fx-text-fill: #FFF;-fx-alignment: CENTER; -fx-font-size:50");
                }
                else {
                    textField.setStyle("-fx-background-color: #176B87;-fx-border-width: 0;" +
                            "-fx-border-radius: 0; -fx-text-fill: #FFF;-fx-alignment: CENTER; -fx-font-size:50; -fx-border-color: #04364A; -fx-border-width: 4; ");
                }
                textField.setOpacity(1);

                // Set initial values (you can replace this with your logic)
                textField.setText(String.valueOf(val));
                gridPane.add(textField, col, row);
            }
        }

        return gridPane;
    }
    public static Button createIconButton(String svg) {


        SVGPath path = new SVGPath();
        path.setContent(svg);
        path.setFill(javafx.scene.paint.Color.WHITE);
        Bounds bounds = path.getBoundsInLocal();

        // scale to size 20x20 (max)
        double scaleFactor = 20 / Math.max(bounds.getWidth(), bounds.getHeight());
        path.setScaleX(scaleFactor);
        path.setScaleY(scaleFactor);
        path.getStyleClass().add("button-icon");

        Button button = new Button();
        button.setPickOnBounds(true); // make sure transparent parts of the button register clicks too
        button.setGraphic(path);
        button.setAlignment(Pos.CENTER);
        button.getStyleClass().add("icon-button");

        return button;
    }
    private HBox createActionButtonContainer(MainApp mainApp) {
        Button statsButton = new Button("Show Statistics");
        Button backButton = new Button("Main Menu");

        backButton.setStyle("-fx-background-color: #04364A;-fx-text-fill: #FFF;" +
                "-fx-alignment: center;-fx-font-size: 15;");
        statsButton.setStyle("-fx-background-color: #04364A;-fx-text-fill: #FFF;" +
                "-fx-alignment: center;-fx-font-size: 15;");

        backButton.setMinSize(150, 50);
        backButton.setMaxSize(150, 50);
        statsButton.setMaxSize(150, 50);
        statsButton.setMinSize(150, 50);

        //show alert of statistics through calling show statistics method
        backButton.setOnAction(event -> mainApp.changeScene(new Initial(mainApp).getScene()));
        statsButton.setOnAction(event -> showAlertStatistics());

        HBox buttonContainer = new HBox(statsButton, backButton);
        buttonContainer.setAlignment(Pos.CENTER);
        buttonContainer.setSpacing(5);
        return buttonContainer;
    }
    private HBox createTraverseButtonContainer(GridPane matrixGrid) {
        SVGPath playIcon = new SVGPath();
        playIcon.setContent("M0 0 L0 10 L10 5 Z");
        playIcon.setFill(Color.WHITE);

        SVGPath pauseIcon = new SVGPath();
        pauseIcon.setContent("M0 0 H3 V10 H0 M6 0 H9 V10 H6");
        pauseIcon.setFill(Color.WHITE);

        // Create Previous and Next buttons and handle their actions
        Button prevButton = createIconButton("M10 0 L0 5 L10 10 L5 5 Z");
        Button playButton = createIconButton("M0 0 L0 10 L7 5 Z");
        Button nextButton = createIconButton("M0 0 L10 5 L0 10 L5 5 Z");

        prevButton.setStyle("-fx-background-color: #04364A;-fx-text-fill: #FFF;-fx-alignment: center;-fx-font-size: 15;");
        playButton.setStyle("-fx-background-color: #04364A;-fx-text-fill: #FFF;-fx-alignment: center;-fx-font-size: 15;");
        nextButton.setStyle("-fx-background-color: #04364A;-fx-text-fill: #FFF;-fx-alignment: center;-fx-font-size: 15;");

        prevButton.setMaxSize(100, 50);
        prevButton.setMinSize(100, 50);
        playButton.setMaxSize(100, 50);
        playButton.setMinSize(100, 50);
        nextButton.setMinSize(100, 50);
        nextButton.setMaxSize(100, 50);

        prevButton.setDisable(currentStateIndex == 0);
        nextButton.setDisable(currentStateIndex == pathOfStates.length - 1);

        prevButton.setOnAction(event -> {
            // Handle Previous button action
            if (currentStateIndex > 0) {
                currentStateIndex--;
                updateMatrix(matrixGrid, pathOfStates[currentStateIndex]);
            }
            prevButton.setDisable(currentStateIndex == 0);
            nextButton.setDisable(currentStateIndex == pathOfStates.length - 1);
        });

        Timeline timeline = new Timeline();
        int delay = 250;
        playButton.setOnAction(event -> {
            if (timeline.getStatus() == Timeline.Status.RUNNING) {
                timeline.pause();
                playButton.setGraphic(playIcon);
            }
            else {
                playButton.setGraphic(pauseIcon);
                if (currentStateIndex == pathOfStates.length - 1) {
                    currentStateIndex = 0;
                    updateMatrix(matrixGrid, pathOfStates[currentStateIndex]);
                }
                if (timeline.getStatus() == Timeline.Status.PAUSED)
                    timeline.play();
                else {
                    timeline.getKeyFrames().clear();
                    timeline.getKeyFrames().add(new KeyFrame(Duration.millis(delay), e -> {
                        if (currentStateIndex < pathOfStates.length - 1) {
                            currentStateIndex++;
                            updateMatrix(matrixGrid, pathOfStates[currentStateIndex]);
                        } else {
                            timeline.stop();
                            playButton.setGraphic(playIcon);
                        }
                    }));
                    timeline.setCycleCount(Timeline.INDEFINITE);
                    timeline.play();
                }
            }
        });

        nextButton.setOnAction(event -> {
            // Handle Next button action
            if (currentStateIndex < pathOfStates.length - 1) {
                currentStateIndex++;
                updateMatrix(matrixGrid, pathOfStates[currentStateIndex]);
            }
            prevButton.setDisable(currentStateIndex == 0);
            nextButton.setDisable(currentStateIndex == pathOfStates.length - 1);
        });

        // Create button container (HBox) and center the buttons
        HBox buttonContainer = new HBox(prevButton, playButton, nextButton);
        buttonContainer.setAlignment(Pos.CENTER);
        buttonContainer.setSpacing(5);
        return buttonContainer;
    }

    private void showAlertStatistics() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Statistics For This Solution");

        Text text = new Text("Solution Statistics \n");
        text.setStyle("-fx-font-size: 25px; -fx-font-weight: bold; -fx-fill: #04364A;");
        alert.getDialogPane().setHeader(text);
        //make title in center
        alert.getDialogPane().setPadding(new Insets(20));
        alert.getDialogPane().setBackground(new Background(new BackgroundFill(javafx.scene.paint.Color.valueOf("#BEF2FF"), CornerRadii.EMPTY, Insets.EMPTY)));

        Text text1 = new Text("1. Number of nodes Expanded: " + nodesExpanded + "\n" +
                "2. Max Depth of the solution: " + depth + "\n" +
                "3. Cost to reach the solution: " + costToReach + "\n"
                + "4. Running Time: " + runningTime + " ms");
        text1.setStyle("-fx-font-size: 25px;; -fx-fill: #04364A;");
        alert.getDialogPane().setContent(text1);

        //make default alert size bigger
        alert.getDialogPane().setMinSize(500, 300);
        alert.initModality(Modality.APPLICATION_MODAL);
        alert.setResizable(true);
        alert.showAndWait();
    }
    private void updateMatrix(GridPane matrix, long state) {
        boolean goalReached = state == 12345678L;
        for (int row = 0, col = 0;row*3 + col < 9;col++) {
            // Move to the next row if the current column exceeds 2
            row += col / 3;
            col = col % 3;

            // Update the TextField at the current row and column with the corresponding value
            TextField textField = (TextField) matrix.getChildren().get(row * 3 + col);
            textField.setText(String.valueOf(state % 10));

            if((state % 10) == 0) {
                textField.setText("");
                textField.setStyle("-fx-background-color: #BEF2FF;-fx-border-width: 0;" +
                        "-fx-border-radius: 0; -fx-text-fill: #FFF;-fx-alignment: CENTER; -fx-font-size:50");
            }
            else {
                textField.setStyle("-fx-background-color: #176B87;-fx-border-width: 0;" +
                        "-fx-border-radius: 0; -fx-text-fill: #FFF;-fx-alignment: CENTER; -fx-font-size:50 ; -fx-border-color: #04364A; -fx-border-width: 4;");
            }

            if (goalReached){
                textField.setStyle("-fx-background-color: #45A298;-fx-border-width: 0;" +
                        "-fx-border-radius: 0; -fx-text-fill: #FFF;-fx-alignment: CENTER; -fx-font-size:50; -fx-border-color: #17594A; -fx-border-width: 4;");
                //make color opacity higher
                if((state % 10) == 0) {
                    textField.setText("");
                    textField.setStyle("-fx-background-color: #BEF2FF;-fx-border-width: 0;" +
                            "-fx-border-radius: 0; -fx-text-fill: #FFF;-fx-alignment: CENTER; -fx-font-size:50");
                }
            }
            textField.setOpacity(1);
            state /= 10;
        }
    }

    //show statistics method

}
