package lotto.domain;

import lotto.dto.LottoNumberDTO;

public class BonusNumber {
    private static final String WRONG_RANGE_MESSAGE = "보너스 번호는 1-45 숫자로 입력해주세요";
    Integer bonusNumber;

    public BonusNumber(LottoNumberDTO lottoNumber) {
        validateRange(lottoNumber.getNumber());
        bonusNumber = lottoNumber.getNumber();
    }

    private void validateRange(int input) {
        if (input > 0 && input <= 45) return;
        throw new IllegalArgumentException(WRONG_RANGE_MESSAGE);
    }

    @Override
    public boolean equals(Object obj) {
        return bonusNumber.equals(obj);
    }
}
