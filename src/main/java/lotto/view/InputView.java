package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.validator.InputValidator;

public class InputView {
    private static final String MoneyGuide = "구입금액을 입력해 주세요.";
    private static final String WinningNumberGuide = "당첨 번호를 입력해 주세요.";
    private static final String BonusNumberGuide = "보너스 번호를 입력해 주세요.";

    private InputView() {
    }

    public static String inputMoney() {
        System.out.println(MoneyGuide);
        String money = Console.readLine();
        InputValidator.validateMoney(money);
        return money;
    }

    public static String inputWinningNumber() {
        System.out.println(WinningNumberGuide);
        String winningNumber = Console.readLine();
        InputValidator.validateWinningNumber(winningNumber);
        return winningNumber;
    }

    public static String inputBonusNumber() {
        System.out.println(BonusNumberGuide);
        String bonusNumber = Console.readLine();
        InputValidator.validateBonusNumber(bonusNumber);
        return bonusNumber;
    }
}
