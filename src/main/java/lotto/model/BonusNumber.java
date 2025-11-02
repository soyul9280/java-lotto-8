package lotto.model;

import lotto.message.ErrorMessage;

public class BonusNumber {
    private final int number;

    private BonusNumber(int number) {
        this.number = number;
    }

    public static BonusNumber create(int number) {
        validateMinus(number);
        validateZero(number);
        return new BonusNumber(number);
    }

    private static void validateMinus(int result) {
        if (result < 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_MINUS.getMessage());
        }
    }

    private static void validateZero(int result) {
        if (result == 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_ZERO.getMessage());
        }
    }

    public int getNumber() {
        return number;
    }
}
