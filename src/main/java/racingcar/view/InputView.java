package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String getCars() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String carNamesInput = Console.readLine();
        Console.close();
        return carNamesInput;
    }

    public static String getRaceRounds() {
        System.out.println("시도할 회수는 몇회인가요?");
        String roundsInput = Console.readLine();
        Console.close();
        return roundsInput;
    }
}