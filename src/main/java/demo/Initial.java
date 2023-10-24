package demo;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import search_algorithms.FirstSearch;
import search_algorithms.HeuristicSearch;
import search_algorithms.Search;

public class Initial {
    private Scene scene;
    private long goalState = 12345678L;
    public Initial(Main mainApp) {
        VBox layout = new VBox(30);
        layout.setStyle("-fx-background-color: #59f85d; -fx-padding: 20;");

        GridPane matrixGrid = createMatrixGrid(142375680L);

        Text title = new Text("Enter Your Puzzle");
        title.setStyle("-fx-font-weight: bold;-fx-text-fill: #333;-fx-font-size: 20;");

        Button DFSbutton = createButton("DFS");
        Button BFSbutton = createButton("BFS");
        Button AStarManattanbutton = createButton("A* -> Manhattan Distance");
        Button AStarEuclideanbutton = createButton("A* -> Euclidean Distance");
        HBox traverseButtons = createButtonContainer(new Button[]{DFSbutton, BFSbutton,
                AStarManattanbutton, AStarEuclideanbutton});

        DFSbutton.setOnAction(e -> {
            Search<Long> dfs = new FirstSearch<>('D');
            long initState = getMatrixState(matrixGrid);
            System.out.println(initState);
            dfs.search(initState, goalState);
            mainApp.changeScene(new MatrixPreview(mainApp, dfs.getPath(initState, goalState)).getScene());
        });
        BFSbutton.setOnAction(e -> {
            Search<Long> bfs = new FirstSearch<>('B');
            long initState = getMatrixState(matrixGrid);
            bfs.search(initState, goalState);
            mainApp.changeScene(new MatrixPreview(mainApp, bfs.getPath(initState, goalState)).getScene());
        });
        AStarEuclideanbutton.setOnAction(e -> {
            Search<Long> A_M = new HeuristicSearch<>('M');
            long initState = getMatrixState(matrixGrid);
            A_M.search(initState, goalState);
            mainApp.changeScene(new MatrixPreview(mainApp, A_M.getPath(initState, goalState)).getScene());
        });
        AStarManattanbutton.setOnAction(e -> {
            Search<Long> A_E = new HeuristicSearch<>('M');
            long initState = getMatrixState(matrixGrid);
            A_E.search(initState, goalState);
            mainApp.changeScene(new MatrixPreview(mainApp, A_E.getPath(initState, goalState)).getScene());
        });

        layout.getChildren().addAll(title, matrixGrid, traverseButtons);
        scene = new Scene(layout, 550, 400);
    }

    public Scene getScene() { return scene; }

    private Button createButton(String text){
        Button button = new Button(text);
        button.setStyle("-fx-background-color: rgb(225,192,25);-fx-text-fill: #333;" +
                "-fx-alignment: center;-fx-font-size: 20");
        return button;
    }

    private HBox createButtonContainer(Button[] buttons) {
        // Create button container (HBox) and center the buttons
        HBox buttonContainer = new HBox(buttons);
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

        // Populate the grid with TextField inputs (you can replace this with your actual input logic)
        for (int row = 2; row >= 0; row--) {
            for (int col = 2; col >= 0; col--) {
                TextField textField = new TextField();
                textField.setStyle("-fx-background-color: #34e039; -fx-border-color: #000000; " +
                        "-fx-border-radius: 5; -fx-alignment: CENTER;");

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
}
