package lotto.model;

import lotto.message.ErrorMessage;

public class Money {
    private final int amount;

    private Money(int amount) {
        this.amount = amount;
    }

    public static Money create(int amount) {
        validateAmount(amount);
        return new Money(amount);
    }

    private static void validateAmount(int amount) {
        if(amount < 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_MONEY_MINUS.getMessage());
        }
        if (amount == 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_MONEY_ZERO.getMessage());
        }
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_MONEY_NOT_THOUSAND_UNIT.getMessage());
        }
    }
}
