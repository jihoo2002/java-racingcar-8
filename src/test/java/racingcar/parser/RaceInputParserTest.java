package racingcar.parser;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.util.ErrorMessage;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RaceInputParserTest {

    @Test
    @DisplayName("유효한 시도 횟수가 입력되면 숫자를 반환")
    void 유효한_시도_횟수_변환() {
        String input = "5";
        int result = RaceInputParser.parseRounds(input);

        assertThat(result).isEqualTo(5);
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "1.5", "", " ", "숫자아님"})
    @DisplayName("시도 횟수가 숫자로 변환될 수 없는 값(문자, 소수, 빈 값 등)이면 예외를 발생")
    void 시도_횟수가_숫자가_아닌_경우_예외_발생(String input) {
        assertThatThrownBy(() -> RaceInputParser.parseRounds(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_ROUND_NOT_NUMBER.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "-1", "-100"})
    @DisplayName("시도 횟수가 0 이하의 정수이면 예외를 발생")
    void 시도_횟수가_0_이하인_경우_예외_발생(String input) {
        assertThatThrownBy(() -> RaceInputParser.parseRounds(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_ROUND_LESS_THAN_ONE.getMessage());
    }
}
