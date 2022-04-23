package racingcar;

public class Car {
    private final Name name;
    private Position position;
    private final Score score;

    public Car(String name) {
        this.name = new Name(name);
        this.score = new Score();
    }

    public DirectionStatus getStatus() {
        if (this.position.isMoveForwardPosition()) {
            return DirectionStatus.MOVE_FORWARD;
        }
        return DirectionStatus.STOP;
    }

    public void setPosition(int position) {
        this.position = new Position(position);
        setScore();
    }

    public String getName() {
        return this.name.getName();
    }

    private void setScore() {
        if(getStatus().isMoveForward())
            this.score.setMoveForward();
    }

    public String getScore() {
        return this.score.getScore();
    }

    public String getResult() {
        return getName() + " : " + getScore();
    }
}
