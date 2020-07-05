package app.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Score implements Comparable<Score> {
    private StringProperty username;
    private IntegerProperty score;

    public Score(String username, int score) {
        this.setUsername(username);
        this.setScore(score);
    }

    public Score(String username, String score) {
        this.setUsername(username);
        this.setScore(Integer.valueOf(score));
    }

    public StringProperty usernameProperty() {
        if (this.username == null) this.username = new SimpleStringProperty(this, "username");
        return this.username;
    }

    public IntegerProperty scoreProperty() {
        if (this.score == null) this.score = new SimpleIntegerProperty(this, "score");
        return this.score;
    }

    public void setUsername(String value) {
        usernameProperty().set(value);
    }

    public String getUsername() {
        return usernameProperty().get();
    }

    public void setScore(Integer value) {
        scoreProperty().set(value);
    }

    public Integer getScore() {
        return scoreProperty().get();
    }

    @Override
    public int compareTo(Score o) {
        return this.getScore().compareTo(o.getScore());
    }
}