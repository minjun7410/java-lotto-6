package lotto.domain;

import lotto.constants.ErrorMessage;

public class WinningNumber {
    private final Lotto lottoNumber;
    private final BonusNumber bonusNumber;

    public WinningNumber(Lotto lottoNumber, BonusNumber bonusNumber) {
        validateLottoNumberContainBonusNumber(lottoNumber, bonusNumber);
        this.lottoNumber = lottoNumber;
        this.bonusNumber = bonusNumber;
    }

    public Rank calculateRank(Lotto lotto) {
        int matchCount = lotto.getMatchCount(lottoNumber);
        boolean bonusMatched = lotto.contains(bonusNumber);
        Rank rank = Rank.findByMatchCount(matchCount, bonusMatched);
        rank.addCount();
        return Rank.findByMatchCount(matchCount, bonusMatched);
    }

    private void validateLottoNumberContainBonusNumber(Lotto lottoNumber, BonusNumber bonusNumber) {
        if (lottoNumber.contains(bonusNumber)) throw new IllegalArgumentException(ErrorMessage.LOTTO_CONTAIN_BONUS_NUMBER_MESSAGE.toString());
    }
}
