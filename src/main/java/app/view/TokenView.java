package app.view;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class TokenView extends Circle {

    public TokenView() {
        super(50, Color.GREY);
    }

    public void setRed() {
        super.setFill(Color.RED);
    }

    public void setYellow() {
        super.setFill(Color.YELLOW);
    }

    public void setGrey() {
        super.setFill(Color.GREY);
    }

    public void setHoverGrey() {
        super.setFill(Color.DARKGREY);
    }
}