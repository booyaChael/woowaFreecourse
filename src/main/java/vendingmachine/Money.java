package vendingmachine;

import java.util.HashMap;
import java.util.Map;

public class Money {
	private int money;
	private Map<Coin, Integer> coins;
	public Money(String input){
		validateMoney(input);
		this.money = Integer.parseInt(input);
		this.coins = new HashMap<>();
	}

	public int getMoney(){
		return this.money;
	}

	public Map<Coin, Integer> makeCoins(){
		Map<Coin, Integer> coins = new HashMap<>();

		int moneyLeft = money;
		// 자판기 내 남은돈(machineMoneyLeft)가 존재하는 동안은 Coin을 계속 생성하여 coins에 넣는다.
		while(moneyLeft > 0){
			Coin coin = RandomCoinGenerator.makeRandomCoin();
			if(coin.getAmount() <= moneyLeft){
				coins.put(coin, coins.getOrDefault(coin, 0) + 1);
				moneyLeft -= coin.getAmount();
			}
		}
		this.coins = coins;
		return coins;
	}

	public Map<Coin, Integer> makeCoinsByAmount(int amount){
		Map<Coin, Integer> coinsMade = new HashMap<>();

		int amountLeft = amount;
		for(Coin coin : Coin.values()){
			int needQuantity = amountLeft / coin.getAmount();
			int possibleQuantity = this.coins.getOrDefault(coin, 0);
			int quantity = Math.min(needQuantity, possibleQuantity);
			coinsMade.put(coin, quantity);
			this.coins.put(coin, this.coins.getOrDefault(coin, 0) - quantity);
			amountLeft -= coin.getAmount() * quantity;
		}
		return coinsMade;
	}

	public boolean isLessThan(int comparedMoney){
		return money < comparedMoney;
	}

	public void decrease(int amount) {money -= amount;
	}

	private void validateMoney(String input){
		Validator.checkIsNumber(input);
		int money = Integer.parseInt(input);
		Validator.checkIsDividedBy10(money);
	}
}
