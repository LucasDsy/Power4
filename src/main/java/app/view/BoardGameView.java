package app.view;

import javafx.scene.layout.BorderPane;

public class BoardGameView extends BorderPane {
    private GridView gridView;
    // private ScoreView scoreView;

    public BoardGameView(int nbCols, int nbRows, int tokenSize) {
        super();

        gridView = new GridView(nbCols, nbRows, tokenSize);
        // scoreView = new ScoreView();

        this.setCenter(gridView);
        // this.setBottom(scoreView);
    }

    public GridView getGridView() {
        return gridView;
    }
}