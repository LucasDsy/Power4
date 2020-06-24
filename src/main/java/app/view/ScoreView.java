package app.view;

import javafx.scene.layout.BorderPane;

public class ScoreView extends BorderPane {
    private ScorePane scoreP1;
    private ScorePane scoreP2;

    public ScoreView() {
        super();

        this.scoreP1 = new ScorePane(1);
        this.scoreP2 = new ScorePane(2);

        super.setLeft(this.scoreP1);
        super.setRight(this.scoreP2);
    }

    public void refreshScores(int score1, int score2) {
        this.scoreP1.setScore(score1);
        this.scoreP2.setScore(score2);
    }
}