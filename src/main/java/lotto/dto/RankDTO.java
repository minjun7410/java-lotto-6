package lotto.dto;

public class RankDTO {
    private final int winningCount;
    private final String prizeText;

    public RankDTO(int winningCount, String prizeText) {
        this.winningCount = winningCount;
        this.prizeText = prizeText;
    }

    public int getWinningCount() {
        return winningCount;
    }

    public String getPrizeText() {
        return prizeText;
    }
}
