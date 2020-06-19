package app.view;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;

public class GridView extends Scene {

    private GridPane grid;
    private ArrayList<TokenView> tokens;

    public GridView(Group root, int cols, int rows, int gap) {
        super(root, cols*100+(gap-1)*cols, rows*100+(gap-1)*rows, Color.BLUE);

        this.grid = new GridPane();
        this.grid.setVgap(gap);
        this.grid.setHgap(gap);

        this.tokens = new ArrayList<TokenView>();

        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                TokenView tokenView = new TokenView();
                this.tokens.add(tokenView);
                grid.add(tokenView, i, j);
            }
        }

        root.getChildren().add(grid);
    }

    public ArrayList getTokens() {
        return this.tokens;
    }
}