package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.message.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class WinningNumberTest {
    @ParameterizedTest(name = "[case] {0}")
    @ValueSource(ints = {-1,-2,-3,-9999})
    @DisplayName("예외: 당첨번호에 음수가 포함되는 경우")
    public void InvalidWinningNumber_Minus_Fail(int winningNumber) {
        assertThatThrownBy(() ->new WinningNumber(winningNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_WINNING_NUMBER_MINUS.getMessage());
    }

    @Test
    @DisplayName("예외: 당첨번호에 중복 숫자가 포함되는 경우")
    public void InvalidWinningNumber_Minus_Fail() {
        assertThatThrownBy(() ->new WinningNumber(List.of(1,2,3,4,4,6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_WINNING_NUMBER_DUPLICATE.getMessage());
    }

    @Test
    @DisplayName("예외: 당첨번호에 ,가 연속으로 들어오는 경우")
    public void InvalidWinningNumber_Minus_Fail() {
        assertThatThrownBy(() ->new WinningNumber(List.of(1,2,3,,4,5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_WINNING_NUMBER_DUPLICATE.getMessage());
    }

    @Test
    @DisplayName("예외: 당첨번호가 6자리 초과인 경우")
    public void InvalidWinningNumber_Minus_Fail() {
        assertThatThrownBy(() ->new WinningNumber(List.of(1,2,3,4,5,6,7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_WINNING_NUMBER_DUPLICATE.getMessage());
    }
}
