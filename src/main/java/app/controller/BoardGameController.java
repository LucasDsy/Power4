package app.controller;

import app.view.TokenView;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class BoardGameController extends Scene {
    private GridPane grid;

    public BoardGameController(Group root, int cols, int rows, int gap) {
        super(root, cols*100+(gap-1)*cols, rows*100+(gap-1)*rows, Color.BLUE);

        this.grid = new GridPane();
        this.grid.setVgap(gap);
        this.grid.setHgap(gap);

        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                TokenView tokenView = new TokenView();
                setOnMouseHoverListeners(tokenView);
                grid.add(tokenView, i, j);
            }
        }

        root.getChildren().add(grid);
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
}