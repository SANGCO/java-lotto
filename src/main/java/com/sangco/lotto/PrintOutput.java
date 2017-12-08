package com.sangco.lotto;

import com.sangco.lotto.model.Lottos;
import com.sangco.lotto.model.WinnerList;

public class PrintOutput {
	public static void printMyLotto(Lottos lottos) {
		blank();
		System.out.println("수동으로 " + lottos.getPickNumbInPrsn() + "장, 자동으로 "
				+ (lottos.getHowManyBuy() - lottos.getPickNumbInPrsn()) + "장을 구매했습니다.");
		for (int i = 0; i < lottos.getHowManyBuy(); i++) {
			System.out.println(lottos.getLottoArray().get(i).getPickedNumb().toString());
		}
	}

	public static void printLottoResult(Lottos lottos, long profit) {
		System.out.println("당첨 통계\r\n---------");
		for (int i = 3; i <= 6; i++) {
			System.out.println(Match.valueOf(i).getCountOfMatch() + "개 일치 (" + Match.valueOf(i).getWinningMoney()
					+ "원)- " + lottos.getList().getWinnerData(i) + "개");

			if (i == 5 & lottos.getList().getBonus() != 0) {
				System.out.println(Match.valueOf(i + 2).getCountOfMatch() - 2 + "개 일치, 보너스 볼 일치("
						+ Match.valueOf(i + 2).getWinningMoney() + "원)- " + lottos.getList().getWinnerData(i) + "개");
			}

			if (i == 5 & lottos.getList().getBonus() == 0) {
				System.out.println(Match.valueOf(i + 2).getCountOfMatch() - 2 + "개 일치, 보너스 볼 일치("
						+ Match.valueOf(i + 2).getWinningMoney() + "원)- 0개");
			}
		}

		System.out.println("총 수익률은 " + profit / (lottos.getHowManyBuy() * 1000) * 100 + "%입니다.");
	}

	private static void blank() {
		System.out.println();
	}
}
