package lotto.utils;

import java.util.List;
import lotto.message.DelimiterPattern;

public final class SplitByDelimiter {
    private SplitByDelimiter() {
    }

    public static List<String> winningNumberDelimiter(String input) {
        String delimiter = DelimiterPattern.WINNING_NUMBER.getDelimiter();
        return List.of(input.split(delimiter));
    }
}
