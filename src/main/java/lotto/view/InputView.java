package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.dto.LottoNumberDTO;

import java.util.Arrays;
import java.util.List;

public class InputView {
    private static final String INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요.";
    private static final String TOO_MANY_MONEY_MESSAGE = "너무 큰 금액을 입력했습니다.";

    private String getUserInput() {
        return Console.readLine().trim();
    }

    public List<LottoNumberDTO> getLottoNumbersInput() {
        String userInput = getUserInput();
        return Arrays.stream(userInput.split(","))
                .map(String::trim)
                .map(this::convertInputToLottoNumber)
                .map(LottoNumberDTO::new)
                .toList();
    }

    public int getPaidMoneyInput() {
        String userInput = getUserInput();
        return convertInputToLottoNumber(userInput);
    }

    public LottoNumberDTO getBonusNumberInput() {
        String userInput = getUserInput();
        return new LottoNumberDTO(convertInputToLottoNumber(userInput));
    }

    private int convertInputToLottoNumber(String input) {
        validateInputNumber(input);
        validateExceedMaximum(input);
        return Integer.parseInt(input);
    }

    private void validateInputNumber(String input) {
        if (input.matches("\\d*")) return;
        throw new IllegalArgumentException(INPUT_NUMBER_MESSAGE);
    }

    private void validateExceedMaximum(String input) {
        if (input.length() <= 10 && Long.parseLong(input) <= Integer.MAX_VALUE) return;
        throw new IllegalArgumentException(TOO_MANY_MONEY_MESSAGE);
    }
}

