package lotto;

import lotto.model.BonusNumber;
import lotto.model.Lottos;
import lotto.model.Money;
import lotto.model.WinningNumber;
import lotto.utils.TypeConverter;
import lotto.view.InputView;

public class LottoController {
    public LottoController() {
        new LottoController();
    }

    public void startLotto() {
        Money money = initMoney();
        Lottos lottos = Lottos.create(money);
        initWinningNumber();
        initBonusNumber();
    }

    private static Money initMoney() {
        String amount = InputView.inputMoney();
        int amountNumber = TypeConverter.changeToNumber(amount);
        return Money.create(amountNumber);
    }

    private static WinningNumber initWinningNumber() {
        String winningNumberInput = InputView.inputWinningNumber();
        return WinningNumber.create(winningNumberInput);
    }

    private static BonusNumber initBonusNumber() {
        String bonusNumberInput = InputView.inputBonusNumber();
        int bonusNumber = TypeConverter.changeToNumber(bonusNumberInput);
        return BonusNumber.create(bonusNumber);
    }
}
