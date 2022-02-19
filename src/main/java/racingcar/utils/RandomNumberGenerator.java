package racingcar.utils;

import java.util.concurrent.ThreadLocalRandom;

public class RandomNumberGenerator {

    private static final int START_EXCLUSIVE = 0;
    private static final int END_EXCLUSIVE = 10;

    private RandomNumberGenerator() {
    }

    public static int pickRandomNumber() {
        return ThreadLocalRandom.current().nextInt(START_EXCLUSIVE, END_EXCLUSIVE);
    }
}
