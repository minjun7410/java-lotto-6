package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.*;
import lotto.dto.LottoNumberDTO;
import lotto.dto.RankDTO;
import lotto.dto.YieldRateDTO;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LottoGameController {
    private final InputView inputView;
    private final OutputView outputView;

    public LottoGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {
        LottoOwner lottoOwner = new LottoOwner();
        purchaseLottoByOwner(lottoOwner);
        WinningNumber winningNumber = generateWinningNumber();
        calculateLottoResult(lottoOwner, winningNumber);
        calculateYieldRate(lottoOwner);
    }

    private void purchaseLottoByOwner(LottoOwner lottoOwner) {
        while (true) {
            try {
                outputView.printPurchasePriceInputText();
                int paidMoneyInput = inputView.getPaidMoneyInput();
                LottoTicket lottoTicket = lottoOwner.purchaseLotto(paidMoneyInput);
                outputView.printTicketNumber(lottoTicket.getTicketNumber());
                printLottos(lottoOwner.getLottos());
                return;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private WinningNumber generateWinningNumber() {
        Lotto lottoNumber = generateLottoNumber();
        while (true) {
            try {
                BonusNumber bonusNumber = generateBonusNumber();
                return new WinningNumber(lottoNumber, bonusNumber);
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private Lotto generateLottoNumber() {
        while (true) {
            try {
                outputView.printLottoNumbersInputText();
                List<LottoNumberDTO> lottoNumbers = inputView.getLottoNumbersInput();
                return Lotto.fromLottoNumberDTO(lottoNumbers);
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private BonusNumber generateBonusNumber() {
        while (true) {
            try {
                outputView.printBonusNumberInputText();
                return new BonusNumber(inputView.getBonusNumberInput());
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private void calculateLottoResult(LottoOwner lottoOwner, WinningNumber winningNumber) {
        lottoOwner.calculateResult(winningNumber);
        printLottoResult();
    }

    private void printLottos(List<Lotto> lottos) {
        lottos.forEach((lotto) -> outputView.printLottoNumbers(lotto.getNumbers()));
    }

    private void printLottoResult() {
        outputView.printLottoResultStartText();
        List<RankDTO> ranks = Rank.getRanks();
        Collections.reverse(ranks);
        for (RankDTO rank : ranks) {
            outputView.printLottoResult(rank);
        }
    }

    private void calculateYieldRate(LottoOwner lottoOwner) {
        YieldRate yieldRate = lottoOwner.calculateYieldRate();
        outputView.printYieldRate(YieldRateDTO.from(yieldRate));
    }
}
