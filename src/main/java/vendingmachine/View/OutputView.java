package vendingmachine.View;

import java.util.Map;

import vendingmachine.Coin;

public class OutputView {
	static public void printMachineCoins(Map<Coin, Integer> coins){
		for (Map.Entry<Coin, Integer> entry : coins.entrySet()) {
			Coin coin = entry.getKey();
			int count = entry.getValue();
			System.out.println(coin.getAmount() + "원 - " + count + "개");
		}
	}

	static public void printUserMoneyLeft(int userMoney){
		System.out.printf("투입 금액: %d원\n", userMoney);
	}
}
