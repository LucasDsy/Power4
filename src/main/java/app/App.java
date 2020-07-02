package app;

import app.controller.BoardGameController;
import app.controller.MenuController;
import app.model.GameModel;
import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {
    private static Stage stage;
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = new MenuController();
        
        primaryStage = stage;
        primaryStage.show();
    }
 
    public static void main(String[] args) {
        Application.launch(args);
    }

    public static void openMenuController() {
        stage.close();
        stage = new MenuController();
        stage.show();
    }

    public static void openBoardController(GameModel gameModel) {
        stage.close();
        stage = new BoardGameController(gameModel);
        stage.show();
    }
}
