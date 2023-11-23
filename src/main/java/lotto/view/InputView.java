package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.constants.ErrorMessage;
import lotto.dto.LottoNumberDTO;

import java.util.Arrays;
import java.util.List;

public class InputView {
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
        throw new IllegalArgumentException(ErrorMessage.INPUT_NUMBER_MESSAGE.toString());
    }

    private void validateExceedMaximum(String input) {
        if (input.length() <= 10 && Long.parseLong(input) <= Integer.MAX_VALUE) return;
        throw new IllegalArgumentException(ErrorMessage.TOO_MANY_MONEY_MESSAGE.toString());
    }
}

