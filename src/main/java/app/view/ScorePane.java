package app.view;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class ScorePane extends Pane {
    private int playerNumber;
    private Text score;
    
    public ScorePane(int playerNumber) {
        super();

        this.playerNumber = playerNumber;
        this.score = new Text("P" + String.valueOf(this.playerNumber) + " SCORE: 0");
        
        this.setStyle();

        super.getChildren().add(score);
    }

    public void setScore(int score) {
        this.score.setText("P" + String.valueOf(this.playerNumber) + " SCORE: " + String.valueOf(score));
    }

    private void setStyle() {
        this.score.setFill(Color.WHITE);
        this.score.setFont(Font.font("Helvetica", FontWeight.BOLD, FontPosture.REGULAR, 24));

        this.score.setTextAlignment(TextAlignment.CENTER);
    }
}