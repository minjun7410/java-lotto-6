package lotto.domain;

import lotto.dto.RankDTO;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Rank {
    FIRST(6, false, 0, 2000000000, "6개 일치 (2,000,000,000원) - %d개\n"),
    SECOND(5, true, 0, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n"),
    THIRD(5, false, 0, 1500000, "5개 일치 (1,500,000원) - %d개\n"),
    FOURTH(4, false, 0, 50000, "4개 일치 (50,000원) - %d개\n"),
    FIFTH(3, false, 0, 5000, "3개 일치 (5,000원) - %d개\n"),
    FAIL(0, false, 0, 0, "");

    private final int lottoMatchCount;
    private final boolean bonusRequired;
    private int winningCount;
    private final int prize;
    private final String prizeText;

    Rank(int lottoMatchCount, boolean bonusRequired, int winningCount, int prize, String prizeText) {
        this.lottoMatchCount = lottoMatchCount;
        this.bonusRequired = bonusRequired;
        this.winningCount = winningCount;
        this.prize = prize;
        this.prizeText = prizeText;
    }

    public static Rank findByMatchCount(int lottoMatchCount, boolean bonusMatched) {
        for (Rank rank : Rank.values()) {
            if (rank.lottoMatchCount == lottoMatchCount && (!rank.bonusRequired || bonusMatched)) {
                return rank;
            }
        }
        return Rank.FAIL;
    }

    public static List<RankDTO> getRanks() {
        return Arrays.stream(values())
                .map(Rank::getRank)
                .collect(Collectors.toList());
    }

    public void addCount() {
        this.winningCount += 1;
    }

    private RankDTO getRank() {
        return new RankDTO(this.winningCount, this.prizeText);
    }

    public int getPrize() {
        return this.prize;
    }
}
