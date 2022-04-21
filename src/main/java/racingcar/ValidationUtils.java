package racingcar;

import java.util.Objects;

public class ValidationUtils {
    public static final int MAX_LENGTH = 5;

    public static boolean validCarName(String name) {
        return Objects.nonNull(name) && (name.length() <= MAX_LENGTH);
    }
}
