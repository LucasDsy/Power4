package app.model;

public class Token {
    State state;
    Player player;

    /** Class relative types */
    public enum Player {
        NONE(0),
        P1(1),
        P2(2),
        P3(3),
        P4(4);

        private int number;

        Player(int number) {
            this.number = number;
        }

        @Override
        public String toString() {
            return "Player " + String.valueOf(number);
        }

        public int getNumber() {
            return number;
        }
    }

    public enum State {
        FREE, TAKEN;
    }

    /** Constructor */
    public Token() {
        state = State.FREE;
        player = Player.NONE;
    }

    /** Accessors */
    public void setState(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public State getPlayer() {
        return state;
    }
}