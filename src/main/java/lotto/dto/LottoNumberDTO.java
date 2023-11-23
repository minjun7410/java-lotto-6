package lotto.dto;

import lotto.constants.Constants;
import lotto.constants.ErrorMessage;

public class LottoNumberDTO {
    private final int number;

    public LottoNumberDTO(int number) {
        validateNumberRange(number);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    private void validateNumberRange(int number) {
        if (number >= Constants.MINIMUM_LOTTO_NUMBER.getNumber() && number <= Constants.MAXIMUM_LOTTO_NUMBER.getNumber()) return;
        throw new IllegalArgumentException(ErrorMessage.RANGE_ERROR_TEXT.toString());
    }
}
