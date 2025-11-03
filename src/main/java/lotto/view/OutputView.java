package lotto.view;

import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.Money;
import lotto.model.Rank;
import lotto.model.RankCountRepository;

public class OutputView {
    private static final String ERROR_FORMAT = "[ERROR] ";
    private static final String PURCHASE_RATE_FORMAT = "총 수익률은 %.1f%%입니다.%n";
    private static final String MATCH_COUNT_FORMAT = "%s - %d개%n";
    private static final String HEADER_FORMAT = "당첨 통계";
    private static final String HEADER_DELIMITER = "---";
    private static final String PURCHASE_COUNT_FORMAT = "개를 구매했습니다.";
    private static final int DEFAULT_TOTAL_PRIZE = 0;
    private static final int PERCENTAGE_UNIT = 100;
    private static final String NEWLINE = System.lineSeparator();

    public static void printPurchasedLottos(Lottos lottos) {
        System.out.println(NEWLINE + lottos.getSize() + PURCHASE_COUNT_FORMAT);
        for (Lotto lotto : lottos.getLottoItems()) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void printStatistics(RankCountRepository rankRepo, Money money) {
        System.out.println(NEWLINE + HEADER_FORMAT + NEWLINE + HEADER_DELIMITER);
        int totalPrize = DEFAULT_TOTAL_PRIZE;

        for (Rank rank : Rank.values()) {
            if (rank == Rank.NORANK) {
                continue;
            }
            int count = rankRepo.getCount(rank);
            totalPrize += count * rank.getWinningPrice();
            System.out.printf(MATCH_COUNT_FORMAT, rank.getMessage(), count);
        }

        double yield = (double) totalPrize / money.getAmount() * PERCENTAGE_UNIT;
        System.out.printf(PURCHASE_RATE_FORMAT, yield);
    }

    public static void printException(IllegalArgumentException e) {
        System.out.println(ERROR_FORMAT + e.getMessage());
    }
}
