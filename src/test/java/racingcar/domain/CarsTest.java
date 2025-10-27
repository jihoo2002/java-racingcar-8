package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.util.ErrorMessage;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class CarsTest {

    @Test
    @DisplayName("자동차 이름 중복 시 예외 발생")
    void 자동차_이름_중복_검증() {
        List<String> names = List.of("car1", "car2", "car1");

        assertThatThrownBy(() -> new Cars(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.DUPLICATE_CAR_NAME.getMessage());
    }

    @Test
    @DisplayName("getWinners는 가장 앞선 자동차 반환")
    void 승자_확인() {
        Cars cars = new Cars(List.of("car1", "car2"));
        List<Car> carList = cars.getCars();

        carList.get(0).move(5);
        carList.get(1).move(3);

        List<Car> winners = cars.getWinners();
        assertEquals(1, winners.size());
        assertEquals("car1", winners.get(0).getCarName());
    }

    @Test
    @DisplayName("최대 위치가 동일하면 다수 승자 반환")
    void 공동_승자_확인() {
        Cars cars = new Cars(List.of("car1", "car2"));
        List<Car> carList = cars.getCars();

        carList.get(0).move(5);
        carList.get(1).move(5);

        List<Car> winners = cars.getWinners();
        assertEquals(2, winners.size());
    }
}
