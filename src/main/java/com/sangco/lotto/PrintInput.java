package com.sangco.lotto;

import java.util.ArrayList;
import java.util.Scanner;

import com.sangco.lotto.model.Lottos;

public class PrintInput {
	public static int howMuchPay(Scanner scanner) {
		System.out.println("구입금액을 입력해 주세요.");
		return howMany(scanner.nextInt());
	}

	private static int howMany(int money) {
		return money / 1000;
	}

	public static int pickInperson(Scanner scanner) {
		System.out.println("몇 장을 수동으로 구매 하시겠습니까?");
		return scanner.nextInt();
	}

	public static ArrayList<String> inPutInPerson(Lottos lottos, Scanner scanner) {
		ArrayList<String> inputLott = new ArrayList<>();
		System.out.println("수동으로 구매할 번호를 입력해 주세요.");
		
		for (int i = 0; i < lottos.getPickNumbInPrsn(); i++) {
			inputLott.add(scanner.nextLine());
		}
		return inputLott;
	}

	public static String[] inputWinLotto(Scanner scanner) {
		System.out.println("지난 주 당첨 번호를 입력해 주세요.");
		return scanner.nextLine().split(",");
	}

	public static int inputBonusNumb(Scanner scanner) {
		System.out.println("보너스 볼을 입력해 주세요.");
		return scanner.nextInt();
	}
}
