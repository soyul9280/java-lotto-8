package lotto.validator;

import java.util.regex.Pattern;
import lotto.message.ErrorMessage;

public final class InputValidator {
    private static final Pattern NOT_NUMBER_PATTERN = Pattern.compile("[^0-9]");

    private InputValidator() {
    }

    public static void validateMoney(String money) {
        if (money == null) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_MONEY_NULL.getMessage());
        }
        if(money.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_MONEY_EMPTY.getMessage());
        }
        if(NOT_NUMBER_PATTERN.matcher(money).find()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_MONEY_NOT_NUMBER.getMessage());
        }
    }
    public static void validateWinningNumber(String winningNumber) {
        if (winningNumber == null) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_WINNING_NUMBER_NULL.getMessage());
        }
    }
}
