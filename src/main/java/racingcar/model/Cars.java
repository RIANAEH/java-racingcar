package racingcar.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.utils.RandomNumberGenerator;

public class Cars {

    private final static int FIRST_WINNER_INDEX = 0;
    private final static int EQUAL_CODE = 0;

    private final List<Car> cars;

    public Cars(final List<Car> cars) {
        this.cars = cars;
    }

    public void move() {
        for (Car car : cars) {
            car.moveForward(RandomNumberGenerator.pickRandomNumber());
        }
    }

    public void sort() {
        Collections.sort(cars);
    }

    public Car getFirstPositionCar() {
        return cars.get(FIRST_WINNER_INDEX);
    }

    public List<Car> getSamePositionCars(Car firstPositionCar) {
        return cars.stream()
                .filter(car -> car.compareTo(firstPositionCar) == EQUAL_CODE)
                .collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return cars;
    }
}
