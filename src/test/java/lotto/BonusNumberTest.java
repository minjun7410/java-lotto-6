package lotto;

import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.dto.LottoNumberDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BonusNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {46, 0})
    void 보너스번호_범위밖인값_예외처리_테스트(int input) {
        assertThatThrownBy(() -> new BonusNumber(new LottoNumberDTO(input))).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스번호_포함하는지_테스트() {
        Lotto winningLotto = new Lotto(List.of(1,2,3,4,5,6));
        BonusNumber bonusNumber = new BonusNumber(new LottoNumberDTO(3));
        assertThat(winningLotto.contains(bonusNumber)).isTrue();
    }

    @Test
    void 보너스번호_포함하지않는지_테스트() {
        Lotto winningLotto = new Lotto(List.of(1,2,3,4,5,6));
        BonusNumber bonusNumber = new BonusNumber(new LottoNumberDTO(7));
        assertThat(winningLotto.contains(bonusNumber)).isFalse();
    }
}
