package lotto.dto;

public class LottoNumberDTO {
    private static final String RANGE_ERROR_TEXT = "1에서 45까지의 숫자를 입력해주세요.";
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
        throw new IllegalArgumentException(RANGE_ERROR_TEXT);
    }
}
