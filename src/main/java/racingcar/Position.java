package racingcar;

public class Position {
    public static final int GO_LOWER_BOUND = 4;
    private final int value;

    public Position(int position) {
        this.value = position;
    }

    public boolean isMoveForward() {
        return this.value  >= GO_LOWER_BOUND;
    }
}
