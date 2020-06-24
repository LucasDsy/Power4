package app.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class BoardGameView extends VBox {
    private GridView gridView;
    private ScoreView scoreView;

    public BoardGameView(int nbCols, int nbRows) {
        super(30);

        this.gridView = new GridView(nbCols, nbRows);
        this.scoreView = new ScoreView();

        super.getChildren().addAll(gridView, scoreView);

        this.setStyle();
    }

    public GridView getGridView() {
        return this.gridView;
    }

    private void setStyle() {
        this.gridView.setAlignment(Pos.CENTER);
        super.setBackground(new Background(new BackgroundFill(Color.BLUE, CornerRadii.EMPTY, Insets.EMPTY)));
    }
}