package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.message.ErrorMessage;

public class InputView {
    private static final String MoneyGuide = "구입금액을 입력해 주세요.";

    private InputView() {
    }

    public static String inputMoney() {
        System.out.println(MoneyGuide);
        String money = Console.readLine();
        validateMoney(money);
        return money;
    }

    public static void validateMoney(String money) {
        if (money == null) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_MONEY_NULL.getMessage());
        }
    }
}
