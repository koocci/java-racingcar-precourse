package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {
    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car();
    }

    @ParameterizedTest(name = "차량_전진_여부_판단")
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void 차량_전진_여부_판단(int position) {
        car.setPosition(position);
        DirectionStatus status = car.getStatus();
        assertThat(status).isEqualTo(DirectionStatus.MOVE_FORWARD);
    }

    @ParameterizedTest(name = "차량_멈춤_여부_판단")
    @ValueSource(ints = {1, 2, 3})
    void 차량_멈춤_여부_판단(int position) {
        car.setPosition(position);
        DirectionStatus status = car.getStatus();
        assertThat(status).isEqualTo(DirectionStatus.STOP);
    }
}
