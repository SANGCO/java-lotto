package com.sangco.lotto;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import com.sangco.lotto.model.Lottos;
import com.sangco.lotto.model.UserLotto;
import com.sangco.lotto.model.WinLotto;
import com.sangco.lotto.model.WinnerList;

public class PlayTest {
	private Lottos lottos = new Lottos();
	private Play play = new Play();
	
	@Before
	public void setup() {
		lottos.setHowManyBuy(10);
		lottos.setPickNumbInPrsn(2);
		ArrayList<String> inputLotto = new ArrayList<>();
		inputLotto.add("1,2,3,4,5,6");
		inputLotto.add("1,2,3,4,5,6");
		play.getLottoNumb(lottos, inputLotto);
	}
	
	@Test
	public void getLottoNumbTest() {
		assertEquals(10, lottos.getLottoArray().size());
	}
	
	@Test
	public void getMakeWinLottoInstTest() {
		String[] winLottoArray = {"1","2","3","4","5","6"};
		assertEquals(3, play.makeWinLottoInst(winLottoArray, 3).getBonus());
	}
	
	@Test
	public void findWinnerTest() {
		String[] winLottoArray = {"1","2","3","4","5","6"};
		WinLotto winLotto = new WinLotto(winLottoArray);
		play.findWinner(lottos, winLotto);
		assertEquals(2, lottos.getList().getWinnerData(6));
	}
	
	
	/*@Test
	public void findLottoRateOfProfitTest() {
		WinnerList winnerList = lottos.getList();
		winnerList.countWin(5, true);
		assertEquals(2000000000L, play.findLottoRateOfProfit(winnerList));
	}*/
	
}	