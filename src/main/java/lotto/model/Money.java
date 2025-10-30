package lotto.model;

import lotto.message.ErrorMessage;

public class Money {
    private final int amount;

    public Money(int amount) {
        validateAmount(amount);
        this.amount = amount;
    }

    private void validateAmount(int amount) {
        if(amount < 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_MONEY_MINUS.getMessage());
        }
    }
}
