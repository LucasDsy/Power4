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

    @Override
    public boolean equals(Object obj) {
        boolean equals = false;

        if (obj instanceof PlayerModel) {
            PlayerModel playerModel = (PlayerModel) obj;

            equals = playerModel.username.equals(this.username) && playerModel.color.equals(this.color);
        }

        return equals;
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

    public Color getColor() {
        return color;
    }

    public Token.Player getAttributedNumber() {
        return attributedNumber;
    }
}