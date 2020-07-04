package app.view;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.layout.HBox;

public class ScoreView extends HBox {
    private List<ScorePane> scoreList;

    public ScoreView(List<String> usernameList) {
        super();

        this.scoreList = new ArrayList<>();

        for (String username : usernameList) {
            ScorePane scorePane = new ScorePane(username);
            this.scoreList.add(scorePane);
            super.getChildren().add(scorePane);
        }
    }

    public void refreshScore(String username, int score) {
        for (ScorePane scorePane : scoreList) {
            if (scorePane.getUsername().equals(username)) {
                scorePane.update(score);
            }
        }
    }
}