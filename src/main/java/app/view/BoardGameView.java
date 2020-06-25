package app.view;

import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class BoardGameView extends VBox {

    public BoardGameView(GridView gridView) {
        super(30);
        super.setBackground(new Background(new BackgroundFill(Color.BLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        super.getChildren().addAll(gridView, new ScoreView());
    }
}