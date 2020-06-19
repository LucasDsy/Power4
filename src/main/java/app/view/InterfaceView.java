package app.view;

import javafx.application.Application;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class InterfaceView extends Application {
    
    private final String appTitle = "Puissance 4";
    private GridView my_grid;

    private static final int cols = 7;
    private static final int rows = 6;
    private static final int gap = 10;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Group root = new Group();
        this.my_grid = new GridView(root, cols, rows, gap);
        Scene mainScene = this.my_grid;

        primaryStage.setTitle("appTitle");
        primaryStage.setResizable(false);

        primaryStage.setScene(mainScene);
        primaryStage.show();
    }

    public void initInterface() {
        launch();
    }

    public GridView getGrid() {
        return this.my_grid;
    }
}