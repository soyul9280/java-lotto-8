package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.message.ErrorMessage;
import lotto.utils.SplitByDelimiter;
import lotto.utils.TypeConverter;

public class WinningNumber {
    private static final int DIGIT = 6;
    private final Set<Integer> winningNumbers;

    private WinningNumber(Set<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public static WinningNumber create(String input) {
        List<String> splitedNumber = SplitByDelimiter.winningNumberDelimiter(input);
        Set<Integer> winningNumbers = new HashSet<>();

        for (int i = 0; i < splitedNumber.size(); i++) {
            validateSequenceDelimiter(splitedNumber, i);
            int result = TypeConverter.changeToNumber(splitedNumber.get(i));
            validateMinus(result);
            winningNumbers.add(result);
        }

        validateDuplicate(winningNumbers, splitedNumber);
        validateCount(winningNumbers);

        return new WinningNumber(winningNumbers);
    }

    public boolean hasNumber(int number) {
        return winningNumbers.contains(number);
    }

    private static void validateSequenceDelimiter(List<String> splitedNumber, int i) {
        if (splitedNumber.get(i).isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_SEQUENCE_DELIMITER.getMessage());
        }
    }

    private static void validateMinus(int result) {
        if (result < 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_MINUS.getMessage());
        }
    }

    private static void validateDuplicate(Set<Integer> winningNumbers, List<String> splitedNumber) {
        if (winningNumbers.size() != splitedNumber.size()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_DUPLICATE.getMessage());
        }
    }

    private static void validateCount(Set<Integer> winningNumbers) {
        if (winningNumbers.size() != DIGIT) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_NOT_DIGIT_COUNT.getMessage());
        }
    }

}
