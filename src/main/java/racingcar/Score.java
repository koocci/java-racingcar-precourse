package racingcar;

public class Score {
    private String value = "";

    public void setMoveForward() {
        value += "-";
    }

    public String getScore() {
        return value;
    }
}
