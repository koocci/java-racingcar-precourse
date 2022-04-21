package racingcar;

public class Car {
    private Position position;

    public DirectionStatus getStatus() {
        if(isMoveForward())
            return DirectionStatus.MOVE_FORWARD;
        return DirectionStatus.STOP;
    }

    private boolean isMoveForward() {
        return this.position.isMoveForward();
    }

    public void setPosition(int position) {
        this.position = new Position(position);
    }
}
