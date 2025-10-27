package racingcar.controller;


import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.RacingGame;
import racingcar.dto.CarStatusDto;
import racingcar.parser.RaceInputParser;
import racingcar.util.RandomUtil;
import racingcar.domain.RandomValueGenerator;
import racingcar.parser.CarNamesParser;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.List;

public class RacingGameController {

    private RacingGame racingGame;
    private Cars cars;

    public void startRacingGame() {
        String carNames = InputView.getCars();
        List<String> parsedCarNames = CarNamesParser.parseCarNames(carNames);
        cars = new Cars(parsedCarNames);

        String roundsInput = InputView.getRaceRounds();
        int raceRounds = RaceInputParser.parseRounds(roundsInput);

        RandomUtil randomGenerator = new RandomValueGenerator();
        racingGame = new RacingGame(cars, randomGenerator);

        ResultView.printResultHeader();

        runRace(raceRounds, racingGame, cars);
        ResultView.printWinners(toCarStatusDto(cars.getWinners()));
    }

    private void runRace(int raceRounds, RacingGame racingGame, Cars cars) {
        for (int i = 0; i < raceRounds; i++) {
            racingGame.race();
            ResultView.printRaceStatus(toCarStatusDto(cars.getCars()));
        }
    }

    private List<CarStatusDto> toCarStatusDto(List<Car> cars) {
        return cars.stream()
                .map(car -> new CarStatusDto(car.getCarName(), car.getPosition()))
                .toList();
    }
}
