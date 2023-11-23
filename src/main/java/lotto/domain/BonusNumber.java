package lotto.domain;

import lotto.constants.ErrorMessage;
import lotto.dto.LottoNumberDTO;

public class BonusNumber {
    Integer bonusNumber;

    public BonusNumber(LottoNumberDTO lottoNumber) {
        validateRange(lottoNumber.getNumber());
        bonusNumber = lottoNumber.getNumber();
    }

    private void validateRange(int input) {
        if (input > 0 && input <= 45) return;
        throw new IllegalArgumentException(ErrorMessage.BONUS_RANGE_ERROR_TEXT.toString());
    }

    @Override
    public boolean equals(Object obj) {
        return bonusNumber.equals(obj);
    }
}
