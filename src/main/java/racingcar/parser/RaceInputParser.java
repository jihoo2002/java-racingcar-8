package racingcar.parser;

import racingcar.util.ErrorMessage;

public class RaceInputParser {

    public static int parseRounds(String input) {
        try {
            int rounds = Integer.parseInt(input.trim());
            throwIfInvalidRounds(rounds);

            return rounds;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_ROUND_NOT_NUMBER.getMessage());
        }
    }

    private static void throwIfInvalidRounds(int rounds) {
        if (rounds <= 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_ROUND_LESS_THAN_ONE.getMessage());
        }
    }
}

