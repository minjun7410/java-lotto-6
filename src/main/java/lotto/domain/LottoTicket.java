package lotto.domain;

import lotto.constants.Constants;
import lotto.constants.ErrorMessage;
import lotto.dto.TicketNumberDTO;
import lotto.util.Utils;

import java.util.ArrayList;
import java.util.List;

public class LottoTicket {
    private final int ticketNumber;

    public LottoTicket(int input) {
        validateIsDivided(input);
        ticketNumber = input / Constants.TICKET_PRICE.getNumber();
    }

    public List<Lotto> generateLottos() {
        List<Lotto> lottos = new ArrayList<>();
        for (int ticket = 0; ticket < ticketNumber; ticket++) {
            lottos.add(new Lotto(Utils.generateRandomLottoNumbers(Constants.MINIMUM_LOTTO_NUMBER.getNumber(), Constants.MAXIMUM_LOTTO_NUMBER.getNumber(), Constants.MAXIMUM_LOTTO_NUMBER_COUNT.getNumber())));
        }
        return lottos;
    }

    public TicketNumberDTO getTicketNumber() {
        return new TicketNumberDTO(ticketNumber);
    }

    private void validateIsDivided(int paid) {
        if (paid % Constants.TICKET_PRICE.getNumber() == 0) {
            return;
        }
        throw new IllegalArgumentException(String.format(ErrorMessage.REMAIN_CHANGE_MESSAGE.toString(), Constants.TICKET_PRICE.getNumber()));
    }
}
