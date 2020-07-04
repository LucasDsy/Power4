package app.view;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class ScorePane extends Pane {
    private String username;
    private int score;
    private Text displayText;
    
    public ScorePane(String username) {
        super();

        this.displayText = new Text();
        this.username = username;
        this.score = 0;

        this.updateDisplay();
        this.setStyle();

        super.getChildren().add(displayText);
    }

    public void update(int score) {
        this.score = score;
        this.updateDisplay();
    }

    private void updateDisplay() {
        this.displayText.setText(username + " : " + String.valueOf(this.score));
    }

    private void setStyle() {
        this.displayText.setFill(Color.WHITE);
        this.displayText.setFont(Font.font("Helvetica", FontWeight.BOLD, FontPosture.REGULAR, 24));

        this.displayText.setTextAlignment(TextAlignment.CENTER);
    }

    public String getUsername() {
        return this.username;
    }
}