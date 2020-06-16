package app;

import app.controller.BoardGameController;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    private static final String appTitle = "Puissance 4";
    private static final int cols = 7;
    private static final int rows = 6;
    private static final int gap = 10;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Group root = new Group();
        Scene mainScene = new BoardGameController(root, cols, rows, gap);

        primaryStage.setTitle(appTitle);
        primaryStage.setResizable(false);

        primaryStage.setScene(mainScene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
