package lotto.domain;

import java.util.Map;

public class LottoResult {

    private Map<Rank, Integer> lottoResultMap;

    public LottoResult(Map<Rank, Integer> lottoResultMap) {
        this.lottoResultMap = lottoResultMap;
    }

    public float calculateRateOfReturn(int totalPriceToBuyLotto) {
        return (float) totalPrizeAmount() / (float) totalPriceToBuyLotto;
    }

    private int totalPrizeAmount() {
        int totalPrize = 0;
        for (Rank rank : Rank.values()) {
            totalPrize += Rank.calculate(rank, lottoResultMap.getOrDefault(rank, 0));
        }
        return totalPrize;
    }

    public int rankCount(Rank rank) {
        return lottoResultMap.get(rank);
    }
}
