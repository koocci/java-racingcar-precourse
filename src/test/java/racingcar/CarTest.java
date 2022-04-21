package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.configuration.ErrorMessage.ERR_CAR_NAME_LENGTH_LIMIT_MSG;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {
    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car("hobi");
    }

    @Test
    @DisplayName("차량_이름_설정")
    void 차량_이름_등록() {
        assertThat(car.getName()).isEqualTo("hobi");
    }

    @ParameterizedTest(name = "차량_이름_5자이내_Valid_확인")
    @ValueSource(strings = {"1f123f123f", "3434fq", "zcxv211", "      "})
    void 차량_이름_5자이내_Valid_확인(final String name) {
        assertThatThrownBy(() -> {
            new Car(name);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERR_CAR_NAME_LENGTH_LIMIT_MSG);
    }

    @ParameterizedTest(name = "차량_전진_여부_판단")
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void 차량_전진_여부_판단(int position) {
        car.setPosition(position);
        DirectionStatus status = car.getStatus();
        assertThat(status).isEqualTo(DirectionStatus.MOVE_FORWARD);
    }

    @ParameterizedTest(name = "차량_멈춤_여부_판단")
    @ValueSource(ints = {0, 1, 2, 3})
    void 차량_멈춤_여부_판단(int position) {
        car.setPosition(position);
        DirectionStatus status = car.getStatus();
        assertThat(status).isEqualTo(DirectionStatus.STOP);
    }
}
