package lotto.message;

public enum ErrorMessage {
    INVALID_MONEY_NULL("구매 금액에 null이 올 수 없습니다."),
    INVALID_MONEY_EMPTY("구매 금액이 비어있습니다. 구매 금액을 입력해주세요."),
    INVALID_MONEY_OVER_INT("구매 금액이 너무 큽니다. 2,147,483,647 범위 내에서 입력해주세요.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
