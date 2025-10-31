package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.message.ErrorMessage;
import lotto.utils.SplitByDelimiter;
import lotto.utils.TypeConverter;

public class WinningNumber {
    private final Set<Integer> winningNumbers;
    private WinningNumber(Set<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public static WinningNumber create(String input) {
        List<String> splitedNumber = SplitByDelimiter.winningNumberDelimiter(input);
        splitedNumber.forEach(TypeConverter::changeToNumber);
        Set<Integer> winningNumbers = new HashSet<>();
        validateDuplicate(winningNumbers, splitedNumber);
        return new WinningNumber(winningNumbers);
    }

    private static void validateDuplicate(Set<Integer> winningNumbers, List<String> splitedNumber) {
        if(winningNumbers.size()< splitedNumber.size()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_WINNING_NUMBER_DUPLICATE.getMessage());
        }
    }

}
