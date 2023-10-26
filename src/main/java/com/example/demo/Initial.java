package com.example.demo;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Modality;

import search_algorithms.FirstSearch;
import search_algorithms.HeuristicSearch;
import search_algorithms.Search;

public class Initial {
    private Scene scene;
    private long goalState = 12345678L;
    private long initialState = 854672301L;
    public int depth ;
    public int costToReach ;
    public int nodesExpanded ;
    public long runningTime ;

    public Initial(MainApp mainApp) {
        VBox layout = new VBox(30);
        layout.setStyle("-fx-background-color: #BEF2FF; -fx-padding: 20; -fx-alignment: center;");

        GridPane matrixGrid = createMatrixGrid(initialState);

        Text title = new Text("Enter Your Puzzle");
        title.setStyle("-fx-font-size: 50; -fx-fill: #04364A; -fx-font-weight: bold;");
        HBox titleContainer = new HBox(title);
        titleContainer.setStyle("-fx-font-weight: bold; -fx-font-size: 50 ; -fx-alignment: center;");

        Button DFSbutton = createButton("DFS");
        Button BFSbutton = createButton("BFS");
        Button AStarManattanbutton = createButton("A* : Manhattan");
        Button AStarEuclideanbutton = createButton("A* : Euclidean");
        HBox traverseButtons = createButtonContainer(new Button[]{DFSbutton, BFSbutton,
                AStarManattanbutton, AStarEuclideanbutton});

        DFSbutton.setOnAction(e -> {
            Search<Long> dfs = new FirstSearch<>('D');
            long initState = getMatrixState(matrixGrid);
            dfs.search(initState, goalState);
            if(dfs.isReachedGoalState()) {
                depth = dfs.getDepth();
                costToReach = dfs.getCostOfPath();
                nodesExpanded = dfs.getNodesExpanded();
                runningTime = dfs.getRunningTime();
                mainApp.changeScene(new MatrixPreview(mainApp, dfs.getPath(initState, goalState),
                        nodesExpanded, depth, costToReach, runningTime).getScene());

            }
            else showAlert();
        });
        BFSbutton.setOnAction(e -> {
            Search<Long> bfs = new FirstSearch<>('B');
            long initState = getMatrixState(matrixGrid);
            bfs.search(initState, goalState);
            if(bfs.isReachedGoalState())
            {
                depth = bfs.getDepth();
                costToReach = bfs.getCostOfPath();
                nodesExpanded = bfs.getNodesExpanded();
                runningTime = bfs.getRunningTime();
                mainApp.changeScene(new MatrixPreview(mainApp, bfs.getPath(initState, goalState),
                        nodesExpanded, depth, costToReach, runningTime).getScene());
            }

                else showAlert();
        });
        AStarEuclideanbutton.setOnAction(e -> {
            Search<Long> A_M = new HeuristicSearch<>('M');
            long initState = getMatrixState(matrixGrid);
            A_M.search(initState, goalState);
            if(A_M.isReachedGoalState()) {
                depth = A_M.getDepth();
                costToReach = A_M.getCostOfPath();
                nodesExpanded = A_M.getNodesExpanded();
                runningTime = A_M.getRunningTime();
                mainApp.changeScene(new MatrixPreview(mainApp, A_M.getPath(initState, goalState), nodesExpanded, depth, costToReach, runningTime).getScene());
            }
            else showAlert();
        });
        AStarManattanbutton.setOnAction(e -> {
            Search<Long> A_E = new HeuristicSearch<>('M');
            long initState = getMatrixState(matrixGrid);

            A_E.search(initState, goalState);
            if(A_E.isReachedGoalState()) {
                depth = A_E.getDepth();
                costToReach = A_E.getCostOfPath();
                nodesExpanded = A_E.getNodesExpanded();
                runningTime = A_E.getRunningTime();
                mainApp.changeScene(new MatrixPreview(mainApp, A_E.getPath(initState, goalState), nodesExpanded, depth, costToReach, runningTime).getScene());
            }
            else showAlert();
        });

        layout.getChildren().addAll(titleContainer, matrixGrid, traverseButtons);
        scene = new Scene(layout, 1024, 768);
    }

    public Scene getScene() { return scene; }

    private Button createButton(String text){
        Button button = new Button(text);
        button.setStyle("-fx-background-color: #04364A;-fx-text-fill: #FFF;" +
                "-fx-alignment: center;-fx-font-size: 15; ");
        button.setMinSize(150, 50);
        button.setMaxSize(150, 50);
        return button;
    }

    private HBox createButtonContainer(Button[] buttons) {
        // Create button container (HBox) and center the buttons
        HBox buttonContainer = new HBox(buttons);
        buttonContainer.setSpacing(5);
        buttonContainer.setAlignment(Pos.CENTER);
        return buttonContainer;
    }

    private long getMatrixState(GridPane matrix) {
        long state = 0;
        for (int i = 8;i >= 0;i--) {
            TextField textField = (TextField) matrix.getChildren().get(i);
            state = state * 10 + Integer.parseInt(textField.getText());
        }
        return state;
    }
    private GridPane createMatrixGrid(long state) {
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(5);
        gridPane.setVgap(5);

        for (int row = 2; row >= 0; row--) {
            for (int col = 2; col >= 0; col--) {
                TextField textField = new TextField();
                textField.setStyle("-fx-background-color: #176B87;-fx-border-width: 0;" +
                        "-fx-border-radius: 0; -fx-text-fill: #FFF;-fx-alignment: CENTER; -fx-font-size:50; -fx-border-color: #04364A; -fx-border-width: 4; ");
                textField.setMinSize(150,150);
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


    private void showAlert() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        Text text = new Text("No Solution Found \n");
        //Red
        text.setStyle("-fx-font-size: 25px; -fx-font-weight: bold; -fx-fill: #CD1818;");
        alert.getDialogPane().setHeader(text);
        //make title in center
        alert.getDialogPane().setPadding(new Insets(20));
        alert.getDialogPane().setBackground(new Background(new BackgroundFill(javafx.scene.paint.Color.valueOf("#BEF2FF"), CornerRadii.EMPTY, Insets.EMPTY)));
        Text text1 = new Text("Please try again with another puzzle !!");
        text1.setStyle("-fx-font-size: 25px;; -fx-fill: #04364A;");
        alert.getDialogPane().setContent(text1);
        alert.getDialogPane().setMinSize(500, 300);
        alert.initModality(Modality.APPLICATION_MODAL);
        alert.setResizable(true);
        alert.showAndWait();
    }
}
