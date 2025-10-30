package lotto.message;

public enum ErrorMessage {
    INVALID_INPUT_NULL("입력에 null이 올 수 없습니다."),
    INVALID_INPUT_EMPTY("입력이 비어있습니다."),
    INVALID_INPUT_NOT_NUMBER("입력에는 숫자만 들어올 수 있습니다."),
    INVALID_MONEY_OVER_INT("구매 금액이 너무 큽니다. 2,147,483,647 범위 내에서 입력해주세요."),
    INVALID_MONEY_MINUS("구매 금액에 음수가 들어올 수 없습니다."),
    INVALID_MONEY_ZERO("구매 금액에 0이 올 수 없습니다."),
    INVALID_MONEY_NOT_THOUSAND_UNIT("구매 금액은 1,000단위로 입력해주세요."),

    INVALID_WINNING_NUMBER_NULL("당첨 번호에 null이 올 수 없습니다."),
    INVALID_DELIMITER_POSITION("구분자는 시작과 끝에 올 수 없습니다. 시작과 끝은 숫자로 입력해주세요.");


    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
