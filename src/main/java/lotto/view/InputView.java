package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.validator.InputValidator;

public class InputView {
    private static final String MoneyGuide = "구입금액을 입력해 주세요.";

    private InputView() {
    }

    public static String inputMoney() {
        System.out.println(MoneyGuide);
        String money = Console.readLine();
        InputValidator.validateMoney(money);
        return money;
    }
}
