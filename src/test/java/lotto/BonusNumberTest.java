package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.message.ErrorMessage;
import lotto.model.BonusNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BonusNumberTest {
    @ParameterizedTest(name = "[case] {0}")
    @ValueSource(ints = {1, 12, 23, 34, 44})
    @DisplayName("정상: 보너스 번호가 정상적인 경우")
    public void Valid_Bonus_Number_Success(int number) {
        assertThat(BonusNumber.create(number))
                .isInstanceOf(BonusNumber.class);
    }

    @ParameterizedTest(name = "[case] {0}")
    @ValueSource(ints = {-1, -12, -23, -34, -44})
    @DisplayName("예외: 보너스 번호가 음수인 경우")
    public void Invalid_Bonus_Number_Minus_Fail(int number) {
        assertThatThrownBy(() -> BonusNumber.create(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_NUMBER_MINUS.getMessage());
    }

    @Test
    @DisplayName("예외: 보너스 번호가 0인 경우")
    public void Invalid_Bonus_Number_Zero_Fail() {
        assertThatThrownBy(() -> BonusNumber.create(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_NUMBER_ZERO.getMessage());
    }

}
