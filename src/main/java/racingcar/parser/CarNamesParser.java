package racingcar.parser;

import racingcar.util.ErrorMessage;

import java.util.Arrays;
import java.util.List;

public class CarNamesParser {

    public static List<String> parseCarNames(String input) {
        throwIfCarsListIsNullOrEmpty(input);

        return Arrays.stream(input.split(","))
                .map(String::trim)
                .peek(CarNamesParser::throwIfCarNameEmpty)
                .toList();
    }

    private static void throwIfCarNameEmpty(String car) {
        if (car == null || car.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_CAR_NAME.getMessage());
        }
    }

    private static void throwIfCarsListIsNullOrEmpty(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_CAR_LIST.getMessage());
        }
    }
}
