package vendingmachine;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;

public class CoinsMaker {

	public Map<Coin, Integer> makeCoins(int machineMoney){
		Map<Coin, Integer> coins = new HashMap<>();
		List<Integer> coinList = makeCoinList();

		int machineMoneyLeft = machineMoney;
		while(machineMoneyLeft >= Coin.COIN_10.getAmount()){
			Coin coin = makeRandomCoin(coinList);
			if(coin.getAmount() > machineMoneyLeft){
				continue;
			}
			coins.put(coin, coins.getOrDefault(coin, 0) + 1);
			machineMoneyLeft -= coin.getAmount();
		}
		return coins;
	}

	private List<Integer> makeCoinList(){
		return Arrays.stream(Coin.values())
			.map(Coin::getAmount)
			.collect(Collectors.toList());
	}

	private Coin makeRandomCoin(List<Integer> coinList){
		int coinAmount = Randoms.pickNumberInList(coinList);
		return Coin.findByAmount(coinAmount);
	}
}
