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

        title = new Text("Nombre de victoires");

        leftScoresDisplay = new VBox();
        rightScoresDisplay = new VBox();

        scoreTextList = new ArrayList<>();

        int i = 0;
        
        while (i < usernameList.size()) {
            ScoreText scoreText = new ScoreText(usernameList.get(i));

            scoreTextList.add(scoreText);

            if (i % 2 == 0) {
                leftScoresDisplay.getChildren().add(scoreText);
            } else {
                rightScoresDisplay.getChildren().add(scoreText);
            }

            i++;
        }

        super.setTop(title);
        super.setLeft(leftScoresDisplay);
        super.setRight(rightScoresDisplay);

        setStyle();
    }

    public void refreshScore(String username, int score) {
        for (ScoreText scoreText : scoreTextList) {
            if (scoreText.getUsername().equals(username)) {
                scoreText.update(score);
            }
        }
    }

    private void setStyle() {
        title.setFill(Color.WHITE);
        title.setFont(Font.font("Helvetica", FontWeight.BOLD, FontPosture.REGULAR, 24));

        leftScoresDisplay.setSpacing(20);
        rightScoresDisplay.setSpacing(20);

        for (Node child : leftScoresDisplay.getChildren())
            VBox.setMargin(child, new Insets(0, 0, 0, 20));

        for (Node child : rightScoresDisplay.getChildren())
            VBox.setMargin(child, new Insets(0, 20, 0, 0));

        super.setAlignment(title, Pos.BASELINE_CENTER);
        super.setAlignment(leftScoresDisplay, Pos.BASELINE_RIGHT);
        super.setAlignment(rightScoresDisplay, Pos.BASELINE_LEFT);
    }
}