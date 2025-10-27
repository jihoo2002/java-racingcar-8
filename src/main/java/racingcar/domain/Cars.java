package racingcar.domain;

import racingcar.util.ErrorMessage;

import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(List<String> carNames) {
        validateDuplicateNames(carNames);
        this.cars = carNames.stream()
                .map(Car::new)
                .toList();
    }

    public List<Car> getCars() {
        return List.copyOf(cars);
    }

    public List<Car> getWinners() {
        int maxPosition = getMaxPosition();

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .toList();
    }

    private void validateDuplicateNames(List<String> carNames) {
        long distinctCount = carNames.stream().distinct().count();
        if (distinctCount != carNames.size()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_CAR_NAME.getMessage());
        }
    }

    private int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.NO_CAR_IN_RACE.getMessage()));
    }
}
