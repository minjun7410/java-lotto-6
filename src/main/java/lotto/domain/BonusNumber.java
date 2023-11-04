package lotto.domain;

public class BonusNumber {
    Integer bonusNumber;

    public BonusNumber(int input) {
        validateRange(input);
        bonusNumber = input;
    }

    private void validateRange(int input) {
        if (input > 0 && input <= 45) return;
        throw new IllegalArgumentException("보너스 번호는 1-45 숫자로 입력해주세요");
    }

    @Override
    public boolean equals(Object obj) {
        return bonusNumber.equals(obj);
    }
}
