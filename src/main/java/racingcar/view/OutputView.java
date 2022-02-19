package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import racingcar.model.Car;

public class OutputView {

    private static final String RESULT_MESSAGE = "\n실행 결과";
    private static final String COLON = ":";
    private static final String DASH = "-";
    private static final String WINNER_MESSAGE = "최종 우승자 : ";
    private static final String COMMA = ", ";

    private OutputView() {
    }

    public static void printResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    public static void printResult(final List<Car> cars) {
        cars.forEach(car -> System.out.println(createResultString(car)));
        System.out.println();
    }

    private static String createResultString(final Car car) {
        return car.getCarName() + COLON + progress(car.getPosition());
    }

    private static String progress(final int position) {
        return IntStream.range(0, position)
                .mapToObj(i -> DASH)
                .collect(Collectors.joining());
    }

    public static void printWinners(final List<Car> winners) {
        System.out.println(createWinnersMessage(createWinnersString(winners)));
    }

    private static String createWinnersMessage(final List<String> winners) {
        return WINNER_MESSAGE + String.join(COMMA, winners);
    }

    private static List<String> createWinnersString(final List<Car> winners) {
        return winners.stream()
                .map(Car::getCarName)
                .collect(Collectors.toList());
    }
}
