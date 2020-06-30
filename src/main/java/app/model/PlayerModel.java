package app.model;

import javafx.scene.paint.Color;

public class PlayerModel {
    private String username;
    private int score;
    private Color color;
    private Token.Player attributedNumber;

    /** Constructor */
    public PlayerModel(String username, Color color, Token.Player attributedNumber) {
        this.username = username;
        this.color = color;
        this.attributedNumber = attributedNumber;
        score = 0;
    }

    /** Functions */
    public void increaseScore() {
        this.score++;
    }

    /** Accessors */
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Color getColor() {
        return color;
    }

    public Token.Player getAttributedNumber() {
        return attributedNumber;
    }
}