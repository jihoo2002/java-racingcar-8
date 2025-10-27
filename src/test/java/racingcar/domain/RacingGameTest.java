package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.test.FixedNumberGenerator;
import racingcar.util.RandomUtil;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {

    private Cars cars;
    private Car car1;
    private Car car2;

    @BeforeEach
    void setUp() {
        List<String> carNames = List.of("pobi", "woni");
        cars = new Cars(carNames);
        List<Car> carList = cars.getCars();
        car1 = carList.get(0);
        car2 = carList.get(1);
    }

    @Test
    @DisplayName("무작위 값이 전진 조건에 해당하면 자동차가 전진한다")
    void 경주_실행시_자동차가_전진한다() {
        RandomUtil movingGenerator = new FixedNumberGenerator(4);
        RacingGame racingGame = new RacingGame(cars, movingGenerator);

        racingGame.race();

        assertThat(car1.getPosition()).isEqualTo(1);
        assertThat(car2.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("무작위 값이 정지 조건에 해당하면 자동차가 정지한다")
    void 경주_실행시_자동차가_정지한다() {
        RandomUtil stoppingGenerator = new FixedNumberGenerator(3);
        RacingGame racingGame = new RacingGame(cars, stoppingGenerator);

        racingGame.race();

        assertThat(car1.getPosition()).isEqualTo(0);
        assertThat(car2.getPosition()).isEqualTo(0);
    }
}
