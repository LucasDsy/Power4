package app.view;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class TokenView extends Circle {

    public TokenView(double radius) {
        super(radius, Color.GREY);
    }

    public boolean isAlreadyColored() {
        return (super.getFill() == Color.RED || super.getFill() == Color.YELLOW);
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