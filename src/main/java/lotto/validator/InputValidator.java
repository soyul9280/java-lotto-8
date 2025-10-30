package lotto.validator;

import java.util.regex.Pattern;
import lotto.message.ErrorMessage;

public final class InputValidator {
    private static final Pattern NOT_NUMBER_PATTERN = Pattern.compile("[^0-9]");
    private static final Pattern ONLY_COMMA_PATTERN = Pattern.compile(",");

    private InputValidator() {
    }

    public static void validateMoney(String money) {
        validateNull(money);
        validateBlank(money);
        validateMoneyNumberFormat(money);
    }

    public static void validateWinningNumber(String winningNumber) {
        validateNull(winningNumber);
        validateCommaPosition(winningNumber);
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

    private static void validateCommaPosition(String winningNumber) {
        String commaPattern = ONLY_COMMA_PATTERN.pattern();
        if(winningNumber.startsWith(commaPattern)|| winningNumber.endsWith(commaPattern)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_COMMA_POSITION.getMessage());
        }
    }
}
