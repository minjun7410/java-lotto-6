package lotto.constants;

public enum Constants {
    MAXIMUM_LOTTO_NUMBER_COUNT(6),
    TICKET_PRICE(1000),
    MAXIMUM_LOTTO_NUMBER(45),
    MINIMUM_LOTTO_NUMBER(1),
    ;

    private final int number;

    Constants(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
