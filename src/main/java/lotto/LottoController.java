package lotto;

import lotto.model.Lottos;
import lotto.model.Money;
import lotto.utils.TypeConverter;
import lotto.view.InputView;

public class LottoController {
    public LottoController() {
        new LottoController();
    }

    public void startLotto() {
        Money money = initMoney();
        Lottos.create(money);

    }

    private static Money initMoney() {
        String amount = InputView.inputMoney();
        int amountNumber = TypeConverter.changeToNumber(amount);
        return Money.create(amountNumber);
    }
}
