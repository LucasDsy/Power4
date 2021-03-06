package app.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Score implements Comparable<Score> {
    private StringProperty username;
    private IntegerProperty score;

    public Score(String username, int score) {
        setUsername(username);
        setScore(score);
    }

    public Score(String username, String score) {
        setUsername(username);
        setScore(Integer.valueOf(score));
    }

    public StringProperty usernameProperty() {
        if (username == null) username = new SimpleStringProperty(this, "username");
        return username;
    }

    public IntegerProperty scoreProperty() {
        if (score == null) score = new SimpleIntegerProperty(this, "score");
        return score;
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
        return getScore().compareTo(o.getScore());
    }
}