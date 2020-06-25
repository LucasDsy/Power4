package app.model;

import app.model.enums.State;

public class Token {
    State state;

    public Token() {
        state = State.FREE;
    }

    public void setState(State state) {
        this.state = state;
    }
}