package lotto;

import lotto.domain.BonusNumber;
import lotto.domain.WinningNumber;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningNumberTest {
    @Test
    void 보너스번호_당첨번호_중복_예외처리_테스트() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(2);
        assertThat(lotto.contains(bonusNumber)).isTrue();
        assertThatThrownBy(() -> new WinningNumber(lotto, bonusNumber)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨번호갯수_보너스포함여부_등수_계산_테스트() {
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(7);
        WinningNumber winningNumber = new WinningNumber(winningLotto, bonusNumber);

        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));

        assertThat(winningNumber.calculateRank(lotto).getValue()).isEqualTo("FIRST");
    }
}
