package app.view;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class TokenView extends Circle {

    public TokenView(double radius) {
        super(radius, Color.GREY);
    }

    public boolean isAlreadyColored() {
        return (super.getFill() != Color.GREY && super.getFill() != Color.DARKGREY);
    }
    
    public void setColor(Color color) {
        super.setFill(color);
    }

    public void setNormalColor() {
        super.setFill(Color.GREY);
    }

    public void setHoverColor() {
        super.setFill(Color.DARKGREY);
    }
}