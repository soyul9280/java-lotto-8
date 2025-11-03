package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private List<Lotto> lottoItems;

    private Lottos(List<Lotto> lottoItems) {
        this.lottoItems = lottoItems;
    }

    public static Lottos create(Money money) {
        int tryCount = money.createTryCount();
        List<Lotto> pickedItems = new ArrayList<>(tryCount);
        for (int i = 0; i < tryCount; i++) {
            Lotto lotto = Lotto.createRandomNumbers();
            pickedItems.add(lotto);
        }
        return new Lottos(pickedItems);
    }

    public int getSize() {
        return lottoItems.size();
    }

    public List<Lotto> getLottoItems() {
        return lottoItems;
    }
}
