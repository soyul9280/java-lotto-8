package lotto;

import lotto.model.BonusNumber;
import lotto.model.Lottos;
import lotto.model.Money;
import lotto.model.Rank;
import lotto.model.RankCountRepository;
import lotto.model.WinningNumber;
import lotto.utils.TypeConverter;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    public LottoController() {
    }

    public void startLotto() {
        Money money = initMoney();
        Lottos lottos = Lottos.create(money);
        OutputView.printPurchasedLottos(lottos);

        WinningNumber winningNumber = initWinningNumber();
        BonusNumber bonusNumber = initBonusNumber();

        processResult(lottos, winningNumber, bonusNumber, money);
    }

    private void processResult(Lottos lottos, WinningNumber winningNumber, BonusNumber bonusNumber, Money money) {
        RankCountRepository rankRepo = RankCountRepository.create();

        for (Lotto lotto : lottos.getLottoItems()) {
            Rank rank = calculateRank(lotto, winningNumber, bonusNumber);
            rankRepo.addCountByRank(rank);
        }

        OutputView.printStatistics(rankRepo, money);
    }

    private Rank calculateRank(Lotto lotto, WinningNumber winningNumber, BonusNumber bonusNumber) {
        int matchCount = 0;
        for (Integer number : lotto.getNumbers()) {
            if (winningNumber.hasNumber(number)) {
                matchCount++;
            }
        }

        boolean matchBonus = lotto.hasNumber(bonusNumber.getNumber());
        return Rank.assignRank(matchCount, matchBonus);
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
