package lotto.dto;

import lotto.constants.ErrorMessage;

public class LottoNumberDTO {
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private final int number;

    public LottoNumberDTO(int number) {
        validateNumberRange(number);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    private void validateNumberRange(int number) {
        if (number >= MIN_LOTTO_NUMBER && number <= MAX_LOTTO_NUMBER) return;
        throw new IllegalArgumentException(ErrorMessage.RANGE_ERROR_TEXT.toString());
    }
}
