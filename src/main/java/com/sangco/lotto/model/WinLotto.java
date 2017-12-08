package com.sangco.lotto.model;

public class WinLotto extends Lotto {
	private int bonus = 0;

	public WinLotto(String[] winLotto) {
		setWinLotto(winLotto);
	}

	public void setWinLotto(String[] winLotto) {
		for (String string : winLotto) {
			setPickedNumb(Integer.parseInt(string));
		}
	}

	public int getBonus() {
		return bonus;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}
}