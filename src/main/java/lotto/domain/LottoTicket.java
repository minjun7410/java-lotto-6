package lotto.domain;

import lotto.constants.ErrorMessage;
import lotto.dto.TicketNumberDTO;
import lotto.util.Utils;

import java.util.ArrayList;
import java.util.List;

public class LottoTicket {
    private static final int TICKET_PRICE = 1000;
    private static final int MINIMUM_LOTTO_NUMBER = 1;
    private static final int MAXIMUM_LOTTO_NUMBER = 45;
    private static final int NUMBER_OF_LOTTO = 6;
    private final int ticketNumber;

    public LottoTicket(int input) {
        validateIsDivided(input);
        ticketNumber = input / TICKET_PRICE;
    }

    public List<Lotto> generateLottos() {
        List<Lotto> lottos = new ArrayList<>();
        for (int ticket = 0; ticket < ticketNumber; ticket++) {
            lottos.add(new Lotto(Utils.generateRandomLottoNumbers(MINIMUM_LOTTO_NUMBER, MAXIMUM_LOTTO_NUMBER, NUMBER_OF_LOTTO)));
        }
        return lottos;
    }

    public TicketNumberDTO getTicketNumber() {
        return new TicketNumberDTO(ticketNumber);
    }

    private void validateIsDivided(int paid) {
        if (paid % TICKET_PRICE == 0) {
            return;
        }
        throw new IllegalArgumentException(String.format(ErrorMessage.REMAIN_CHANGE_MESSAGE.toString(), TICKET_PRICE));
    }
}
