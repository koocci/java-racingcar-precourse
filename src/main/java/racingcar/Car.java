package racingcar;

public class Car {
    private final Name name;
    private Position position;

    public Car(String name) {
        this.name = new Name(name);
    }

    public DirectionStatus getStatus() {
        if (isMoveForward()) {
            return DirectionStatus.MOVE_FORWARD;
        }
        return DirectionStatus.STOP;
    }

    private boolean isMoveForward() {
        return this.position.isMoveForward();
    }

    public void setPosition(int position) {
        this.position = new Position(position);
    }

    public String getName() {
        return this.name.getName();
    }
}
