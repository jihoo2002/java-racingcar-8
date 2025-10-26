package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.util.RandomUtil;

public class RandomValueGenerator implements RandomUtil {

    @Override
    public int generateRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
