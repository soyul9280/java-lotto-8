package lotto.message;

public enum DelimiterPattern {
    WINNING_NUMBER(","),
    CANDIDATE_NUMBER(",");

    private final String delimiter;

    DelimiterPattern(String delimiter) {
        this.delimiter = delimiter;
    }

    public String getDelimiter() {
        return delimiter;
    }
}
