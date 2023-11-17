package lotto;

import lotto.dto.LottoNumberDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class LottoNumberTest {
    @DisplayName("로또 번호의 범위가 1에서 45 범위 밖에 있다면 예외를 발생한다")
    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void 범위_밖_로또넘버_예외처리_테스트(int input) {
        assertThatThrownBy(() -> new LottoNumberDTO(input)).isInstanceOf(IllegalArgumentException.class);
    }
}
