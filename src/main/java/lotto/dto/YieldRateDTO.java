package lotto.dto;

import lotto.domain.YieldRate;

public class YieldRateDTO {
    private final double yieldRate;

    public YieldRateDTO(double yieldRate) {
        this.yieldRate = yieldRate;
    }

    public double getYieldRate() {
        return yieldRate;
    }

    public static YieldRateDTO from(YieldRate yieldRate) {
        return new YieldRateDTO(yieldRate.getYieldRate());
    }
}
