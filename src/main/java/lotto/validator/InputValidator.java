package lotto.validator;

import java.util.regex.Pattern;
import lotto.message.ErrorMessage;

public final class InputValidator {
    private static final Pattern NOT_NUMBER_PATTERN = Pattern.compile("[^0-9]");
    private static final Pattern DELIMITER_PATTERN = Pattern.compile(",");
    private static final Pattern ONLY_DELIMITER_PATTERN = Pattern.compile("^[,]*$");
    private static final Pattern NOT_DELIMITER_AND_NUMBER = Pattern.compile("[^,0-9]");

    private InputValidator() {
    }

    public static void validateMoney(String money) {
        validateNull(money);
        validateBlank(money);
        validateMoneyNumberFormat(money);
    }

    public static void validateWinningNumber(String winningNumber) {
        validateNull(winningNumber);
        validateBlank(winningNumber);
        validateExistNumber(winningNumber);
        validateDelimiterAndNumber(winningNumber);
        validateCommaPosition(winningNumber);
    }

    public static void validateBonusNumber(String bonusNumber) {
        validateNull(bonusNumber);
        validateBlank(bonusNumber);
        validateMoneyNumberFormat(bonusNumber);
    }

    private static void validateNull(String input) {
        if (input == null) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_NULL.getMessage());
        }
    }

    private static void validateBlank(String input) {
        if(input.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_EMPTY.getMessage());
        }
    }

    private static void validateMoneyNumberFormat(String input) {
        if(NOT_NUMBER_PATTERN.matcher(input).find()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_NOT_NUMBER.getMessage());
        }
    }

    private static void validateDelimiterAndNumber(String winningNumber) {
        if(NOT_DELIMITER_AND_NUMBER.matcher(winningNumber).find()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_ONLY_DELIMITER_AND_NUMBER.getMessage());
        }
    }

    private static void validateCommaPosition(String winningNumber) {
        String delimiter = DELIMITER_PATTERN.pattern();
        if(winningNumber.startsWith(delimiter)|| winningNumber.endsWith(delimiter)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_DELIMITER_POSITION.getMessage());
        }
    }

    private static void validateExistNumber(String winningNumber) {
        if (winningNumber.matches(ONLY_DELIMITER_PATTERN.pattern())) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NO_NUMBER.getMessage());
        }
    }
}
