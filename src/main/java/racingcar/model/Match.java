package racingcar.model;

import static racingcar.validator.InputValidator.validateLenOfCar;
import static racingcar.validator.InputValidator.validateName;
import static racingcar.validator.InputValidator.validateNumOfMatches;
import static racingcar.validator.InputValidator.validateStringToInteger;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Match {
    private List<Car> carList;
    private int numOfMatches;

    public Match(String carListString, String numOfMatchesString) {
        validateName(carListString);
        validateLenOfCar(carListString);
        validateStringToInteger(numOfMatchesString);
        validateNumOfMatches(numOfMatchesString);

        this.carList = new ArrayList<>();
        for (String carString : carListString.split(",")) {
            this.carList.add(new Car(carString));
        }

        this.numOfMatches = Integer.parseInt(numOfMatchesString);
    }

    public List<Map<String, Integer>> getAllMatchesResult() {
        List<Map<String, Integer>> allMatchesResult = new ArrayList<>();
        for (int i = 0; i < this.numOfMatches; i++) {
            matchStart();
            Map<String, Integer> perMatchResult = getPerMatchResult();
            allMatchesResult.add(perMatchResult);
        }
        return allMatchesResult;
    }

    private void matchStart() {
        for (Car car : this.carList) {
            car.move(Randoms.pickNumberInRange(0, 9));
        }
    }

    private Map<String, Integer> getPerMatchResult() {
        Map<String, Integer> perMatchResult = new HashMap<>();
        for (Car car : this.carList) {
            perMatchResult.put(car.getName(), car.getDistance());
        }
        return perMatchResult;
    }
}
