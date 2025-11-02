package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.validator.InputValidator;

public class InputView {
    private static final String NEWLINE = System.lineSeparator();
    private static final String MONEY_GUIDE = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBER_GUIDE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_GUIDE = "보너스 번호를 입력해 주세요.";

    private InputView() {
    }

    public static String inputMoney() {
        System.out.println(MONEY_GUIDE);
        String money = Console.readLine();
        InputValidator.validateMoney(money);
        return money;
    }

    public static String inputWinningNumber() {
        System.out.println(NEWLINE + WINNING_NUMBER_GUIDE);
        String winningNumber = Console.readLine();
        InputValidator.validateWinningNumber(winningNumber);
        return winningNumber;
    }

    public static String inputBonusNumber() {
        System.out.println(NEWLINE + BONUS_NUMBER_GUIDE);
        String bonusNumber = Console.readLine();
        InputValidator.validateBonusNumber(bonusNumber);
        return bonusNumber;
    }
}
