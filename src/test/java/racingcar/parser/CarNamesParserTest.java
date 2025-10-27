package racingcar.parser;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.util.ErrorMessage;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;;

class CarNamesParserTest {

    @Test
    @DisplayName("입력값이 null이면 예외 발생")
    void 입력값_null_검증() {
        assertThatThrownBy(() -> CarNamesParser.parseCarNames(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.EMPTY_CAR_LIST.getMessage());
    }

    @Test
    @DisplayName("입력값이 빈 문자열이면 예외 발생")
    void 입력값_빈문자열_검증() {
        assertThatThrownBy(() -> CarNamesParser.parseCarNames("   "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.EMPTY_CAR_LIST.getMessage());
    }

    @Test
    @DisplayName("쉼표로 구분된 자동차 이름 정상 파싱")
    void 자동차_이름_파싱() {
        List<String> names = CarNamesParser.parseCarNames(" car1 , car2 ,car3 ");
        assertThat(names).containsExactly("car1", "car2", "car3");
    }

    @Test
    @DisplayName("빈 문자열 자동차 이름이 있으면 예외 발생")
    void 빈_자동차_이름_검증() {
        assertThatThrownBy(() -> CarNamesParser.parseCarNames("car1, ,car3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.EMPTY_CAR_NAME.getMessage());
    }
}
