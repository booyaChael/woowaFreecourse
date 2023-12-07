package vendingmachine.View;

import java.util.Map;

import vendingmachine.Coin;

public class OutputView {
	static public void printMachineCoins(Map<Coin, Integer> coins){
		System.out.println("자판기가 보유한 동전");
		for (Coin coin : Coin.values()) {
			int count = coins.getOrDefault(coin, 0);
			System.out.println(coin.getAmount() + "원 - " + count + "개");
		}
	}

	static public void printUserMoneyLeft(int userMoney){
		System.out.printf("투입 금액: %d원\n", userMoney);
	}

	static public void printChange(Map<Coin, Integer> change) {
		System.out.println("잔돈");

		for (Map.Entry<Coin, Integer> entry : change.entrySet()) {
			Coin coin = entry.getKey();
			int quantity = entry.getValue();

			System.out.println(coin.getAmount() + "원 - " + quantity + "개");
		}
	}

}
