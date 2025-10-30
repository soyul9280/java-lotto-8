package lotto.validator;

import lotto.message.ErrorMessage;

public final class InputValidator {
    private InputValidator() {
    }
    public static void validateMoney(String money) {
        if (money == null) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_MONEY_NULL.getMessage());
        }
    }

}
