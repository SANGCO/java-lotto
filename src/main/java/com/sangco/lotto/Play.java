package com.sangco.lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import com.sangco.lotto.model.Lotto;
import com.sangco.lotto.model.Lottos;
import com.sangco.lotto.model.UserLotto;
import com.sangco.lotto.model.UserLottoBySelf;
import com.sangco.lotto.model.WinLotto;
import com.sangco.lotto.model.WinnerList;

public class Play {

	public void start() {
		Lottos lottos = new Lottos();
		Scanner scanner = new Scanner(System.in);
		lottos.setHowManyBuy(PrintInput.howMuchPay(scanner));
		lottos.setPickNumbInPrsn(PrintInput.pickInperson(scanner));
		lottos = getLotto(lottos, scanner);
		PrintOutput.printMyLotto(lottos);	
		getWin(lottos, scanner);
	}
	
	private Lottos getLotto(Lottos lottos, Scanner scanner) {
		scanner = new Scanner(System.in);
		lottos = getLottoNumb(lottos, PrintInput.inPutInPerson(lottos, scanner));
		return lottos;
	}
	
	private void getWin(Lottos lottos, Scanner scanner) {
		scanner = new Scanner(System.in);
		WinLotto winLotto = makeWinLottoInst(PrintInput.inputWinLotto(scanner), PrintInput.inputBonusNumb(scanner));
		findWinner(lottos, winLotto);			
	}
	
	Lottos getLottoNumb(Lottos lottos, ArrayList<String> inputLotto) {
		for (int i = 0; i < inputLotto.size(); i++) {
			lottos.addLotto(new UserLottoBySelf(inputLotto.get(i).split(",")));
		}
		return getLottoNumbAuto(lottos);
	}

	private Lottos getLottoNumbAuto(Lottos lottos) {
		for (int i = 0; i < lottos.getHowManyBuy() - lottos.getPickNumbInPrsn(); i++) {
			lottos.addLotto(new UserLotto());
		}
		return lottos;
	}

	WinLotto makeWinLottoInst(String[] winLottoArray, int bonus) {
		WinLotto winLotto = new WinLotto(winLottoArray);
		winLotto.setBonus(bonus);
		return winLotto;
	}
	
	void findWinner(Lottos lottos, WinLotto winLotto) {
		for (Lotto lotto : lottos.getLottoArray()) {
			lotto = compareNumb(lotto, winLotto);
			lottos.getList().countWin(lotto.getMatch(), lotto.getIsBonus());
		}
		PrintOutput.printLottoResult(lottos, findLottoRateOfProfit(lottos.getList()));
	}

	private Lotto compareNumb(Lotto lotto, WinLotto winLotto) {
		for (int numb : lotto.getPickedNumb()) {
			if (winLotto.getPickedNumb().contains(numb))
				lotto.setMatch();
			if (winLotto.getBonus() == numb)
				lotto.setIsBonus();
		}
		return lotto;
	}

	long findLottoRateOfProfit(WinnerList list) {
		long total = 0;
		for (int i = 3; i <= 6; i++) {
			total += Match.valueOf(i).getWinningMoney() * list.getWinnerData(i);
			if (i == 5 & list.getBonus() != 0) {
				total += Match.valueOf(i + 2).getWinningMoney() * list.getWinnerData(i);
			}
		}
		return total;
	}

	public static void main(String[] args) {
		Play play = new Play();
		play.start();
	}
}
