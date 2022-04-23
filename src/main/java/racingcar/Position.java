package racingcar;

public class Position {
    public static final int MOVE_FORWARD_LOWER_BOUND = 4;
    private final int value;

    public Position(int position) {
        this.value = position;
    }

    public boolean isMoveForwardPosition() {
        return this.value  >= MOVE_FORWARD_LOWER_BOUND;
    }
}
