package com.sangco.lotto.model;

import java.util.ArrayList;

public class Lottos {
	private ArrayList<Lotto> lottoArray = new ArrayList<>();
	private int howManyBuy = 0;
	private int pickNumbInPrsn = 0;
	private WinnerList list;

	public void addLotto(Lotto lotto) {
		lottoArray.add(lotto);
	}

	public ArrayList<Lotto> getLottoArray() {
		return lottoArray;
	}

	public int getHowManyBuy() {
		return howManyBuy;
	}

	public void setHowManyBuy(int howManyBuy) {
		this.howManyBuy = howManyBuy;
	}

	public int getPickNumbInPrsn() {
		return pickNumbInPrsn;
	}

	public void setPickNumbInPrsn(int pickNumbInPrsn) {
		this.pickNumbInPrsn = pickNumbInPrsn;
	}

	public WinnerList getList() {
		return WinnerList.getInstance();
	}
}
