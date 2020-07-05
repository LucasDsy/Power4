package app.view;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;

public class BackButtonView extends Button {
    
    public BackButtonView() {
        super("Menu");
        this.setStyle();
    }

    public void setNormalColor() {
        super.setBackground(new Background(new BackgroundFill(Color.BLUE, CornerRadii.EMPTY, Insets.EMPTY)));
    }

    public void setHoverColor() {
        super.setBackground(new Background(new BackgroundFill(Color.DARKBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
    }

    private void setStyle() {
        super.setTextAlignment(TextAlignment.CENTER);
        super.setTextFill(Color.WHITE);
        super.setFont(Font.font("Helvetica", FontWeight.BOLD, FontPosture.REGULAR, 24));
        super.setBackground(new Background(new BackgroundFill(Color.BLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        super.setMinWidth(200);
        super.setMinHeight(50);
    }
}