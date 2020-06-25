package app.model.enums;

public enum State {
    FREE(0),
    P1(1),
    P2(2);

    private int number = 0;

    State(int number) {
        this.number = number;
    }

    public int getNumber() {
        return this.number;
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}