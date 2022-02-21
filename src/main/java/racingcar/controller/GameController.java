package racingcar.controller;

import java.util.Arrays;
import java.util.List;

import java.util.stream.Collectors;
import racingcar.model.Car;
import racingcar.model.RacingGame;
import racingcar.utils.validator.CarNamesValidator;
import racingcar.utils.validator.TryCountValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {

    private RacingGame racingGame;

    public void run() {
        ready();
        start();
        result();
    }

    private void ready() {
        final List<Car> cars = createCars(inputCarNames());
        final int tryCount = inputTryCount();

        racingGame = new RacingGame(cars, tryCount);
    }

    private String[] inputCarNames() {
        try {
            String[] carNames = InputView.inputCarNames();
            CarNamesValidator.validateCarNames(carNames);
            return carNames;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return inputCarNames();
        }
    }

    private List<Car> createCars(final String[] carNames) {
        return Arrays.stream(carNames)
                .map(Car::new)
                .collect(Collectors.toList());
    }

    private int inputTryCount() {
        try {
            String tryCountInput = InputView.inputTryCount();
            TryCountValidator.validateTryCount(tryCountInput);
            return Integer.parseInt(tryCountInput);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return inputTryCount();
        }
    }

    private void start() {
        OutputView.printResultMessage();

        while (!racingGame.isEnd()) {
            racingGame.race();
            OutputView.printResult(racingGame.getCars());
        }
    }

    private void result() {
        List<Car> winners = racingGame.getWinners();

        OutputView.printWinners(winners);
    }
}
