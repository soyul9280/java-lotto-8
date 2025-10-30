package lotto;

import static org.assertj.core.api.Assertions.*;

import lotto.message.ErrorMessage;
import lotto.validator.InputValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputValidatorTest {
    @Test
    @DisplayName("예외: 구입 금액이 null인 경우")
    public void InvalidMoney_Null_Fail() {
        assertThatThrownBy(() -> InputValidator.validateMoney(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_MONEY_NULL.getMessage());
    }

    @Test
    @DisplayName("예외: 구입 금액이 빈 문자열인 경우")
    public void InvalidMoney_Empty_Fail() {
        assertThatThrownBy(() -> InputValidator.validateMoney(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_MONEY_EMPTY.getMessage());
    }

    @ParameterizedTest(name = "[case] {0}")
    @ValueSource(strings = {"money",".","1000,2000"})
    @DisplayName("예외: 구입 금액이 숫자가 아닌 경우")
    public void InvalidMoney_Not_Number_Fail(String money) {
        assertThatThrownBy(() -> InputValidator.validateMoney(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_MONEY_NOT_NUMBER.getMessage());
    }

}
