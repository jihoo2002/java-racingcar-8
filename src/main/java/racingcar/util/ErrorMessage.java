package racingcar.util;

public enum ErrorMessage {
    DUPLICATE_CAR_NAME("자동차 이름이 같을 수는 없습니다."),
    EMPTY_CAR_NAME("자동차 이름은 비어있을 수 없습니다."),
    EMPTY_CAR_LIST("자동차 리스트가 null이거나 비어있을 수 없습니다."),
    INVALID_CAR_NAME_LENGTH("자동차 이름은 5자 이하여야 합니다."),
    INVALID_ROUND_LESS_THAN_ONE("시도 횟수는 1회 이상이어야 합니다."),
    INVALID_ROUND_NOT_NUMBER("숫자를 입력해야 합니다."),
    NO_CAR_IN_RACE("경주에 참가한 자동차가 없습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
