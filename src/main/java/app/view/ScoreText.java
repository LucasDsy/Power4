package app.view;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class ScoreText extends Text {
    private String username;
    private int score;

    public ScoreText(String username) {
        super();

        this.username = username;
        this.score = 0;

        this.updateDisplay();
        this.setStyle();

        this.updateDisplay();
    }

    public void update(int score) {
        this.score = score;
        this.updateDisplay();
    }

    private void updateDisplay() {
        super.setText(username + " : " + String.valueOf(this.score));
    }

    private void setStyle() {
        super.setFill(Color.WHITE);
        super.setFont(Font.font("Helvetica", FontWeight.BOLD, FontPosture.REGULAR, 24));
    }

    public String getUsername() {
        return this.username;
    }
}