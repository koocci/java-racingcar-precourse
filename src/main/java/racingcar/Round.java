package racingcar;

import static racingcar.configuration.ErrorMessage.ERR_CAR_POSITION_LIMIT_MSG;
import static racingcar.configuration.ErrorMessage.ERR_RACE_ROUND_INTEGER_LIMIT_MSG;

public class Round {
    private final int value;

    public Round(String round) {
        if (!ValidationUtils.validRaceRound(round)) {
            throw new IllegalArgumentException(ERR_RACE_ROUND_INTEGER_LIMIT_MSG);
        }
        this.value = Integer.parseInt(round);
    }

    public int getRound() {
        return this.value;
    }
}
