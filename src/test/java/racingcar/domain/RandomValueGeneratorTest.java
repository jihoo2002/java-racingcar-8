package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RandomValueGeneratorTest {

    private static final int MIN_RANDOM_VALUE = 0;
    private static final int MAX_RANDOM_VALUE = 10;
    private final RandomValueGenerator generator = new RandomValueGenerator();

    @Test
    @DisplayName("랜덤값을 생성하면 10 내의 범위에 있는지 검증")
    void 랜덤값이_범위_내에_있는지_검증() {
        int randomNumber = generator.generateRandomNumber();

        assertThat(randomNumber).isBetween(MIN_RANDOM_VALUE, MAX_RANDOM_VALUE);
    }
}
