package lotto.model;

public enum Rank {
    FIRST(6, "6개 일치 (2,000,000,000원)",2000000000),
    SECOND(5, "5개 일치, 보너스 볼 일치 (30,000,000원)",30000000),
    THIRD(5,"5개 일치 (1,500,000원)",1500000),
    FOURTH(4, "4개 일치 (50,000원)",50000),
    FIFTH(3,"3개 일치 (5,000원)",5000),
    NORANK(0, "아쉽게 당첨되지 못하셨습니다.",0);


    private final int matchCount;
    private final String message;
    private final int WinningPrice;


    Rank(int matchCount, String message,int WinningPrice) {
        this.matchCount = matchCount;
        this.message = message;
        this.WinningPrice = WinningPrice;
    }

    public static Rank assignRank(int matchCount, Boolean matchBonus) {
        if(matchCount == 6) {
            return FIRST;
        }
        if (matchCount == 5 && matchBonus) {
            return SECOND;
        }
        if(matchCount == 5) {
            return THIRD;
        }
        if(matchCount == 4) {
            return FOURTH;
        }
        if(matchCount == 3) {
            return FIFTH;
        }
        return NORANK;
    }

    public String getMessage() {
        return message;
    }

    public int getWinningPrice() {
        return WinningPrice;
    }
}
