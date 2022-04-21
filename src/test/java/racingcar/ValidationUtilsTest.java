package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ValidationUtilsTest {

    @ParameterizedTest(name = "차량_이름_5자_제한_TRUE")
    @ValueSource(strings = {"carNm", "", "c"})
    void 차량_이름_5자_제한_TRUE(String name) {
        assertThat(ValidationUtils.validCarName(name)).isTrue();
    }

    @ParameterizedTest(name = "차량_이름_5자_제한_FALSE")
    @ValueSource(strings = {"carNmTest", "1@@@@a", "ac@#%zcv2234"})
    void 차량_이름_5자_제한_FALSE(String name) {
        assertThat(ValidationUtils.validCarName(name)).isFalse();
    }

    @Test
    @DisplayName("차량_이름_5자_제한_NULL")
    void 차량_이름_5자_제한_NULL() {
        assertThat(ValidationUtils.validCarName(null)).isFalse();
    }
}
