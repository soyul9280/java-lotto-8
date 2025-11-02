package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.message.ErrorMessage;
import lotto.model.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class MoneyTest {
    @ParameterizedTest(name = "[case] {0}")
    @ValueSource(ints = {1000, 2000,3000,90000})
    @DisplayName("정상: 구입 금액이 정상적인 경우")
    public void Valid_Money_Success(int price) {
        assertThat(Money.create(price))
                .isInstanceOf(Money.class);
    }

    @ParameterizedTest(name = "[case] {0}")
    @ValueSource(ints = {-1000, -9999})
    @DisplayName("예외: 구입 금액이 음수인 경우")
    public void InvalidMoney_Minus_Fail(int price) {
        assertThatThrownBy(() ->Money.create(price))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_MONEY_MINUS.getMessage());
    }

    @Test
    @DisplayName("예외: 구입 금액이 0인 경우")
    public void InvalidMoney_Zero_Fail() {
        assertThatThrownBy(()->Money.create(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_MONEY_ZERO.getMessage());
    }

    @Test
    @DisplayName("예외: 구입 금액이 1000단위가 아닌 경우")
    public void InvalidMoney_Not_Thousand_Fail() {
        assertThatThrownBy(() ->Money.create(29500))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_MONEY_NOT_THOUSAND_UNIT.getMessage());
    }
}
