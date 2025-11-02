package lotto.utils;

import lotto.message.ErrorMessage;

public final class TypeConverter {
    private TypeConverter() {
    }

    public static int changeToNumber(String input) {
        try{
            return Integer.parseInt(input);
        }catch(NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_OVER_INT.getMessage());
        }
    }
}
