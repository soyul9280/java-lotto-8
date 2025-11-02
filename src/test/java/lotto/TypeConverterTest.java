package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.utils.TypeConverter;
import lotto.message.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TypeConverterTest {
    @Test
    @DisplayName("예외: 구입 금액이 int범위가 아닌 경우")
    public void InvalidMoney_Not_Thousand_Fail() {
        assertThatThrownBy(() -> TypeConverter.changeToNumber("2147490000"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_NUMBER_OVER_INT.getMessage());
    }

    @Test
    @DisplayName("예외: 보너스 번호가 int범위가 아닌 경우")
    public void Invalid_BonusNumber_Over_Int() {
        assertThatThrownBy(() -> TypeConverter.changeToNumber("2147490000"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_NUMBER_OVER_INT.getMessage());
    }
}
