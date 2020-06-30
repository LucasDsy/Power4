package app.view;

import java.util.List;

import javafx.scene.control.ScrollBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class MenuView extends BorderPane {
    private ScrollBar playerNumberScrollBar;
    private HBox playerDetailsViews;
    
    public MenuView() {
        super();

        this.playerNumberScrollBar = new ScrollBar();
        this.playerNumberScrollBar.setValue(2);
        this.playerNumberScrollBar.setMax(4);
        this.playerNumberScrollBar.setMin(2);

        this.playerDetailsViews = new HBox();

        super.setTop(playerNumberScrollBar);
        super.setBottom(playerDetailsViews);
    }


}