package racingcar;

import static racingcar.configuration.PrintMessage.INPUT_CAR_NAME_MSG;
import static racingcar.configuration.PrintMessage.INPUT_RACE_ROUND_MSG;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class Race {
    private Cars cars;
    private Round round;

    public void setCarNames() {
        try {
            this.cars = new Cars(Arrays.asList(getCarNamesInput().split(",")));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            setCarNames();
        }
    }

    private String getCarNamesInput() {
        System.out.println(INPUT_CAR_NAME_MSG);
        return Console.readLine();
    }

    public List<Car> findCars() {
        return cars.findCars();
    }

    public int getRound() {
        return this.round.getRound();
    }

    public void setRaceRound() {
        try {
            this.round = new Round(getRaceRoundInput());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            setRaceRound();
        }

    }

    private String getRaceRoundInput() {
        System.out.println(INPUT_RACE_ROUND_MSG);
        return Console.readLine();
    }
}
