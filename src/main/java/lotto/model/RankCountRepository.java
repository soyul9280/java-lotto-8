package lotto.model;

import java.util.HashMap;
import java.util.Map;

public class RankCountRepository {
    private final Map<Rank, Integer> rankCounts;
    private RankCountRepository() {
        this.rankCounts = new HashMap<>();
    }

    public static RankCountRepository create() {
        return new RankCountRepository();
    }

    public void addCountByRank(Rank rank) {
        rankCounts.put(rank, rankCounts.getOrDefault(rank, 0) + 1);
    }

    public int getCount(Rank rank) {
        return rankCounts.getOrDefault(rank, 0);
    }
}
