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
        score = 0;

        updateDisplay();
        setStyle();

        updateDisplay();
    }

    public void update(int score) {
        this.score = score;
        updateDisplay();
    }

    private void updateDisplay() {
        super.setText(username + " : " + String.valueOf(score));
    }

    private void setStyle() {
        super.setFill(Color.WHITE);
        super.setFont(Font.font("Helvetica", FontWeight.BOLD, FontPosture.REGULAR, 24));
    }

    public String getUsername() {
        return username;
    }
}