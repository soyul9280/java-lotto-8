package lotto;

import static org.assertj.core.api.Assertions.*;

import lotto.message.ErrorMessage;
import lotto.validator.InputValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputValidatorTest {

    @Nested
    @DisplayName("구입 금액 테스트")
    class PurchasingMoneyInputTest {
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

    @Nested
    @DisplayName("당첨 번호 테스트")
    class WinningNumberInputTest {
        @Test
        @DisplayName("예외: 당첨 번호가 null인 경우")
        public void InvalidMoney_Null_Fail() {
            assertThatThrownBy(() -> InputValidator.validateWinningNumber(null))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.INVALID_WINNING_NUMBER_NULL.getMessage());
        }

        @Test
        @DisplayName("예외: 당첨 번호가 빈 문자열인 경우")
        public void InvalidMoney_Empty_Fail() {
            assertThatThrownBy(() -> InputValidator.validateWinningNumber(""))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.INVALID_WINNING_NUMBER_EMPTY.getMessage());
        }

        @ParameterizedTest(name = "[case] {0}")
        @ValueSource(strings = {"a,b,c,d,e,f","......","number"})
        @DisplayName("예외: 당첨 번호가 숫자가 아닌 경우")
        public void InvalidMoney_Not_Number_Fail(String number) {
            assertThatThrownBy(() -> InputValidator.validateWinningNumber(number))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.INVALID_WINNING_NUMBER_NOT_NUMBER.getMessage());
        }

        @ParameterizedTest(name = "[case] {0}")
        @ValueSource(strings = {"1,2,3,4,5,6,",",1,2,3,4,5,6"})
        @DisplayName("예외: 당첨 번호가 ,로 시작하거나 끝나는 경우")
        public void InvalidMoney_Not_Number_Fail(String number) {
            assertThatThrownBy(() -> InputValidator.validateWinningNumber(number))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.INVALID_COMMA_POSITION.getMessage());
        }

        @Test
        @DisplayName("예외: 당첨 번호가 ,만 있는 경우")
        public void InvalidMoney_Not_Number_Fail() {
            assertThatThrownBy(() -> InputValidator.validateWinningNumber())
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.INVALID_NO_NUMBER.getMessage());
        }

        @ParameterizedTest(name = "[case] {0}")
        @ValueSource(strings = {"1,!,3,4,5,6,",",1/2/3/4/5.6"})
        @DisplayName("예외: 당첨 번호가 , 제외 특수문자가 오는 경우")
        public void InvalidMoney_Not_Number_Fail(String number) {
            assertThatThrownBy(() -> InputValidator.validateWinningNumber(number))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.INVALID_COMMA_SPECIAL_CHARACTER.getMessage());
        }
    }
}
