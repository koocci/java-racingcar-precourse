package racingcar;



import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static racingcar.configuration.ErrorMessage.ERR_CAR_NAME_LENGTH_LIMIT_MSG;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class RaceTest {
    private Race race;

    @BeforeEach
    void setUp() {
        race = new Race();
    }

    @Test
    @DisplayName("차량_이름_5자이내_정상_테스트")
    void 차량_이름_5자이내_정상_테스트() {
        setInputStream("pobi,woni,jun");
        race.setCarNames();
        assertThat(race.findCars())
                .extracting(Car::getName)
                .containsExactly("pobi", "woni", "jun");
    }

    @Test
    @DisplayName("차량_이름_5자이내_비정상_재시작_테스트")
    void 차량_이름_5자이내_비정상_재시작_테스트() {
        setInputStream("testtest,123441,!@#$!@$");
        setInputStream("pobi,woni,jun");
        race.setCarNames();
        assertThat(race.findCars())
                .extracting(Car::getName)
                .containsExactly("pobi", "woni", "jun");
    }

    @ParameterizedTest(name = "시도할_횟수_입력_성공")
    @ValueSource(strings = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"})
    void 시도할_횟수_입력_성공(String round) {
        setInputStream(round);
        race.setRaceRound();
        assertThat(race.getRound()).isEqualTo(round);
    }

    @ParameterizedTest(name = "시도할_횟수_입력_실패_재시작")
    @ValueSource(strings = {"-1", "a", "@", " ", "", "3r3", "31rm", "0x7fffffff", "2147483648"})
    void 시도할_횟수_입력_실패_재시작(String round) {
        setInputStream(round);
        setInputStream("1");
        race.setRaceRound();
        assertThat(race.getRound()).isEqualTo(1);
    }

    private void setInputStream(final String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

}
