package com.sangco.lotto.model;

public class UserLottoBySelf extends Lotto {
	public UserLottoBySelf(String[] inPerson) {
		pickInPerson(inPerson);
	}

	public void pickInPerson(String[] inPerson) {
		for (String string : inPerson) {
			setPickedNumb(Integer.parseInt(string));
		}
	}
}