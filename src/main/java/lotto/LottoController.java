package lotto;

import lotto.model.Money;
import lotto.utils.TypeConverter;
import lotto.view.InputView;

public class LottoController {
    public LottoController() {
        new LottoController();
    }

    public void startLotto() {
        Money money = initMoney();

    }

    private static Money initMoney() {
        String amount = InputView.inputMoney();
        int amountNumber = TypeConverter.changeToNumber(amount);
        return Money.create(amountNumber);
    }
}
