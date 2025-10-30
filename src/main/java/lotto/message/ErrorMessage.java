package lotto.message;

public enum ErrorMessage {
    INVALID_MONEY_NULL("구매 금액에 null이 올 수 없습니다.");
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
