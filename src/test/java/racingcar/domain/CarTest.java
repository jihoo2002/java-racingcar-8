package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.util.ErrorMessage;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {

    @DisplayName("자동차 이름이 5자를 초과하면 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"abcdef", "longlongname"})
    void 자동차_이름_5자_초과시_예외_발생(String longName) {
        assertThatThrownBy(() -> new Car(longName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_CAR_NAME_LENGTH.getMessage());
    }

    @DisplayName("자동차 이름이 비어있거나 null이면 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"", "  "})
    void 자동차_이름_공백시_예외_발생(String emptyName) {
        assertThatThrownBy(() -> new Car(emptyName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.EMPTY_CAR_NAME.getMessage());
    }

    @Test
    @DisplayName("자동차 이름이 null이면 예외 발생")
    void 자동차_이름_null일시_예외_발생() {
        assertThatThrownBy(() -> new Car(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.EMPTY_CAR_NAME.getMessage());
    }

    @DisplayName("자동차 이름이 5자 이하(경계값 포함)이면 정상 생성")
    @ParameterizedTest
    @ValueSource(strings = {"a", "abc", "abcde"})
    void 자동차_이름_5자_이하_정상_생성(String validName) {
        Car car = new Car(validName);

        assertThat(car.getCarName()).isEqualTo(validName);
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @DisplayName("랜덤 숫자가 4 이상이면 position 1 증가")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 9})
    void 숫자_4_이상일_경우_전진(int randomNumber) {
        Car car = new Car("car");
        car.move(randomNumber);

        assertThat(car.getPosition()).isEqualTo(1);
    }

    @DisplayName("랜덤 숫자가 4 미만이면 position 증가하지 않음")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 3})
    void 숫자_4_미만일_경우_정지(int randomNumber) {
        Car car = new Car("car");
        car.move(randomNumber);

        assertThat(car.getPosition()).isZero();
    }
}
