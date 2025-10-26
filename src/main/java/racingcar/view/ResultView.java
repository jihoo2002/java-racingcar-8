package racingcar.view;

import racingcar.dto.CarStatusDto;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    public static void printResultHeader() {
        System.out.println("실행 결과");
    }

    public static void printRaceStatus(List<CarStatusDto> carStatusDtos) {
        for (CarStatusDto dto : carStatusDtos) {
            System.out.println(dto.name() + " : " + "-".repeat(dto.position()));
        }
        System.out.println();
    }

    public static void printWinners(List<CarStatusDto> winners) {
        String winnersNames = winners.stream()
                .map(CarStatusDto::name)
                .collect(Collectors.joining(", "));

        System.out.println("최종 우승자 : " + winnersNames);
    }
}
