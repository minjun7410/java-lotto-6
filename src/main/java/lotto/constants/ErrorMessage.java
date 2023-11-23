package lotto.constants;

public enum ErrorMessage {
    BONUS_RANGE_ERROR_TEXT("보너스 번호는 1-45 숫자로 입력해주세요"),
    WRONG_LOTTO_NUMBER_MESSAGE("6개의 로또 숫자를 입력하세요."),
    DUPLICATE_LOTTO_NUMBER_MESSAGE("중복되지 않은 로또 숫자를 입력해주세요."),
    REMAIN_CHANGE_MESSAGE("잔돈이 남습니다. %d 원 단위로 입력해주세요."),
    LOTTO_CONTAIN_BONUS_NUMBER_MESSAGE("보너스 번호가 당첨 번호 6개 중에 포함되어있습니다."),
    RANGE_ERROR_TEXT("1에서 45까지의 숫자를 입력해주세요."),
    INPUT_NUMBER_MESSAGE("숫자를 입력해주세요."),
    TOO_MANY_MONEY_MESSAGE("너무 큰 금액을 입력했습니다.");


    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString() {
        return errorMessage;
    }
}
