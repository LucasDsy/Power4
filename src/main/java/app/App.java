package app;

import app.controller.BoardGameController;
import app.model.GameModel;
import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage = new BoardGameController();
        primaryStage.show();
    }
 
    public static void main(String[] args) {
        Application.launch(args);
    }
}
