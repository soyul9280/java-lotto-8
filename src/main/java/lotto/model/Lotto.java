package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.message.ErrorMessage;

public class Lotto {
    private static final int MIN_PICK_NUMBER =1;
    private static final int MAX_PICK_NUMBER =45;
    private static final int COUNT_PICK_NUMBER =6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    public static Lotto createRandomNumbers() {
        List<Integer> pickedNumbers = Randoms.pickUniqueNumbersInRange(MIN_PICK_NUMBER, MAX_PICK_NUMBER, COUNT_PICK_NUMBER);
        return new Lotto(pickedNumbers);
    }

    public boolean hasNumber(int number) {
        return numbers.contains(number);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != COUNT_PICK_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private static void validateDuplicate(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_DUPLICATE.getMessage());
        }
    }
}
