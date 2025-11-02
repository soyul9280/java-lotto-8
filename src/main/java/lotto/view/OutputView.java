package lotto.view;

import lotto.Lotto;
import lotto.model.Lottos;
import lotto.model.Money;
import lotto.model.Rank;
import lotto.model.RankCountRepository;

public class OutputView {
    private static final String ErrorFormat = "[ERROR] ";
    private static final String NEWLINE = System.lineSeparator();

    public static void printPurchasedLottos(Lottos lottos) {
        System.out.println(NEWLINE + lottos.getSize() + "개를 구매했습니다.");
        for (Lotto lotto : lottos.getLottoItems()) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void printStatistics(RankCountRepository rankRepo, Money money) {
        System.out.println(NEWLINE + "당첨 통계" + NEWLINE + "---");
        int totalPrize = 0;

        for (Rank rank : Rank.values()) {
            if (rank == Rank.NORANK) {
                continue;
            }
            int count = rankRepo.getCount(rank);
            totalPrize += count * rank.getWinningPrice();
            System.out.printf("%s - %d개%n", rank.getMessage(), count);
        }

        double yield = (double) totalPrize / money.getAmount() * 100;
        System.out.printf("총 수익률은 %.1f%%입니다.%n", yield);
    }

    public static void printException(IllegalArgumentException e) {
        System.out.println(ErrorFormat + e.getMessage());
    }
}
