package app.view;

import app.view.history.HistoryView;
import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class BoardGameView extends HBox {
    private BackButtonView backButtonView;

    public BoardGameView(GridView gridView, ScoreView scoreView, HistoryView historyView) {
        super(30);

        backButtonView = new BackButtonView();
        
        VBox vbox1 = new VBox(30);
        vbox1.getChildren().addAll(gridView, scoreView);

        VBox vbox2 = new VBox(30);
        vbox2.getChildren().addAll(historyView, backButtonView);

        VBox.setVgrow(backButtonView, Priority.ALWAYS);

        super.getChildren().addAll(vbox1, vbox2);
        super.setBackground(new Background(new BackgroundFill(Color.BLUE, CornerRadii.EMPTY, Insets.EMPTY)));
    }

    public BackButtonView getBackButtonView() {
        return backButtonView;
    }
}