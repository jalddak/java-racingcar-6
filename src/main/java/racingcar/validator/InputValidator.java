package racingcar.validator;

import static racingcar.model.ConstantValue.MAX_LEN_OF_CAR_NAME;
import static racingcar.model.ConstantValue.MIN_NUM_OF_CAR;
import static racingcar.model.ConstantValue.MIN_NUM_OF_MATCHES;
import static racingcar.validator.ErrorMessage.BLANK;
import static racingcar.validator.ErrorMessage.EXCEED_MAX_LEN_OF_CAR_NAME;
import static racingcar.validator.ErrorMessage.LESS_THAN_MIN_NUM_OF_CAR;
import static racingcar.validator.ErrorMessage.LESS_THAN_MIN_NUM_OF_MATCHES;
import static racingcar.validator.ErrorMessage.NOT_INTEGER;

public class InputValidator {
    // carList 관련 유효성 검사
    public static void validateName(String carListString) {
        String[] carList = carListString.split(",");
        for (String car : carList) {
            car = car.replaceAll("\\s", "");
            if (car.isEmpty()) {
                throw new IllegalArgumentException(BLANK.getMessage());
            }
        }
    }

    public static void validateLenOfCar(String carListString) {
        String[] carList = carListString.split(",");
        if (carList.length < MIN_NUM_OF_CAR.getValue()) {
            throw new IllegalArgumentException(LESS_THAN_MIN_NUM_OF_CAR.getMessage());
        }
    }

    public static void validateLenOfCarName(String car) {
        if (car.length() > MAX_LEN_OF_CAR_NAME.getValue()) {
            throw new IllegalArgumentException(EXCEED_MAX_LEN_OF_CAR_NAME.getMessage());
        }
    }

    // 경기 횟수 관련 유효성 검사
    public static void validateStringToInteger(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_INTEGER.getMessage());
        }
    }

    public static void validateNumOfMatches(String number) {
        int numOfMatches = Integer.parseInt(number);
        if (numOfMatches < MIN_NUM_OF_MATCHES.getValue()) {
            throw new IllegalArgumentException(LESS_THAN_MIN_NUM_OF_MATCHES.getMessage());
        }
    }
}
