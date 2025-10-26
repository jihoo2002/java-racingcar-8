package racingcar.domain;

import racingcar.util.ErrorMessage;

public class Car {

    private static final int MAX_CAR_NAME_LENGTH = 5;
    private static final int MOVE_THRESHOLD = 4;
    private final String carName;
    private int position = 0;

    public Car(String name) {
        throwIfCarNameTooLong(name);
        this.carName = name;
    }

    public void move(int randomNumber) {
        if (randomNumber >= MOVE_THRESHOLD) {
            position++;
        }
    }

    public String getCarName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }

    private void throwIfCarNameTooLong(String name) {
        if (name.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_CAR_NAME_LENGTH.getMessage());
        }
    }
}
