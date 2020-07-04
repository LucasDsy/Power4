package app.view;

import java.util.ArrayList;
import java.util.List;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class ScoreView extends BorderPane {
    private Text title;
    private VBox leftScoresDisplay;
    private VBox rightScoresDisplay;
    private List<ScoreText> scoreTextList;

    public ScoreView(List<String> usernameList) {
        super();

        this.title = new Text("Nombre de victoires");

        this.leftScoresDisplay = new VBox();
        this.rightScoresDisplay = new VBox();

        this.scoreTextList = new ArrayList<>();

        int i = 0;
        
        while (i < usernameList.size()) {
            ScoreText scoreText = new ScoreText(usernameList.get(i));

            this.scoreTextList.add(scoreText);

            if (i % 2 == 0) {
                this.leftScoresDisplay.getChildren().add(scoreText);
            } else {
                this.rightScoresDisplay.getChildren().add(scoreText);
            }

            i++;
        }

        super.setTop(this.title);
        super.setLeft(this.leftScoresDisplay);
        super.setRight(this.rightScoresDisplay);

        this.setStyle();
    }

    public void refreshScore(String username, int score) {
        for (ScoreText scoreText : scoreTextList) {
            if (scoreText.getUsername().equals(username)) {
                scoreText.update(score);
            }
        }
    }

    private void setStyle() {
        this.title.setFill(Color.WHITE);
        this.title.setFont(Font.font("Helvetica", FontWeight.BOLD, FontPosture.REGULAR, 24));

        this.leftScoresDisplay.setSpacing(20);
        this.rightScoresDisplay.setSpacing(20);

        for (Node child : this.leftScoresDisplay.getChildren())
            VBox.setMargin(child, new Insets(0, 0, 0, 20));

        for (Node child : this.rightScoresDisplay.getChildren())
            VBox.setMargin(child, new Insets(0, 20, 0, 0));

        super.setAlignment(this.title, Pos.BASELINE_CENTER);
        super.setAlignment(this.leftScoresDisplay, Pos.BASELINE_RIGHT);
        super.setAlignment(this.rightScoresDisplay, Pos.BASELINE_LEFT);
    }
}