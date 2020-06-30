package app.model;

public class Token {
    State state;
    Player player;

    /** Class relative types */
    public enum Player {
        NONE, P1, P2, P3, P4;
    }

    public enum State {
        FREE, TAKEN;
    }

    /** Constructor */
    public Token() {
        state = State.FREE;
        player = null;
    }

    /** Accessors */
    public void setState(State state) {
        this.state = state;
    }

    public State getState() {
        return this.state;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public State getPlayer() {
        return this.state;
    }
}