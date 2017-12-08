package com.sangco.lotto.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Lotto {
	private ArrayList<Integer> pickedNumb = new ArrayList<>();;
	private int match = 0;
	private boolean isBonus = false;
	private Lottos winLotto;

	public ArrayList<Integer> getPickedNumb() {
		return pickedNumb;
	}

	public void setPickedNumb(int numb) {
		this.pickedNumb.add(numb);
	}

	public void doSort() {
		Collections.sort(this.pickedNumb);
	}

	public int getMatch() {
		return match;
	}

	public void setMatch() {
		this.match++;
	}

	public boolean getIsBonus() {
		return isBonus;
	}

	public void setIsBonus() {
		this.isBonus = true;
	}

	public Lottos getWinLotto() {
		return winLotto;
	}

	public void setWinLotto(Lottos winLotto) {
		this.winLotto = winLotto;
	}
	
}
