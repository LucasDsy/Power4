package app.controller;

import app.view.BoardGameView;
import app.view.TokenView;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.event.EventHandler;

import java.util.List;

public class BoardGameController extends Stage {
    private static final int width = 700;
    private static final int height = 800;
    private static final int cols = 7;
    private static final int rows = 6;
    private Scene scene;
    private BoardGameView boardGameView;

    public BoardGameController() {
        super();

        this.setTitle("Puissance 4");
        this.setResizable(false);
        this.setWidth(width);
        this.setHeight(height);

        int tokenSize = width/cols;
        this.boardGameView = new BoardGameView(cols, rows, tokenSize);
        
        this.setListeners();

        this.scene = new Scene(boardGameView);
        this.scene.setFill(Color.BLUE);
        
        this.setScene(scene);
    }

    private void setOnMouseHoverListeners(final TokenView tokenView) {
        tokenView.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                tokenView.setHoverGrey();
            }
        });

        tokenView.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                tokenView.setGrey();
            }
        });
    }

    private void setListeners() {
        List<TokenView> tokenViewList = boardGameView.getGridView().getTokenViewList();
        
        for (TokenView tokenView : tokenViewList) {
            setOnMouseHoverListeners(tokenView);
        }
    }
}