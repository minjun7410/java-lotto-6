package lotto.domain;

import lotto.constants.Constants;
import lotto.constants.ErrorMessage;
import lotto.dto.LottoNumberDTO;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicatedNumber(numbers);
        this.numbers = numbers;
    }

    public static Lotto fromLottoNumberDTO(List<LottoNumberDTO> numbers) {
        return new Lotto(numbers.stream()
                .map(LottoNumberDTO::getNumber)
                .toList());
    }

    public boolean contains(Object obj) {
        return numbers.contains(obj);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != Constants.MAXIMUM_LOTTO_NUMBER_COUNT.getNumber()) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_LOTTO_NUMBER_MESSAGE.toString());
        }
    }

    // TODO: 추가 기능 구현
    public int getMatchCount(Lotto lotto) {
        int matchCount = (int) numbers.stream()
                .filter(lotto::contains)
                .count();
        return matchCount;
    }

    public List<LottoNumberDTO> getNumbers() {
        return numbers.stream()
                .map(number -> new LottoNumberDTO(number))
                .toList();
    }

    private void validateDuplicatedNumber(List<Integer> numbers) {
        Set<Integer> kindOfNumber = new HashSet<>(numbers);
        if (kindOfNumber.size() == numbers.size()) return;
        throw new IllegalArgumentException(ErrorMessage.DUPLICATE_LOTTO_NUMBER_MESSAGE.toString());
    }
}
