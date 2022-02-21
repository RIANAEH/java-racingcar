package racingcar.model;

import java.util.List;

public class RacingGame {

    private final static int TRY_COUNT_END_NUMBER = 0;

    private final Cars cars;
    private int tryCount;

    public RacingGame(List<Car> cars) {
        this(cars, 0);
    }

    public RacingGame(List<Car> cars, int tryCount) {
        this.cars = new Cars(cars);
        this.tryCount = tryCount;
    }

    public boolean isEnd() {
        return tryCount == TRY_COUNT_END_NUMBER;
    }

    public void race() {
        cars.move();
        tryCount--;
    }

    public List<Car> getWinners() {
        cars.sort();
        return cars.getSamePositionCars(cars.getFirstPositionCar());
    }

    public List<Car> getCars() {
        return cars.getCars();
    }
}
