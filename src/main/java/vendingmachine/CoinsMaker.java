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

		int machineMoneyLeft = machineMoney;
		// 자판기 내 남은돈(machineMoneyLeft)가 존재하는 동안은 Coin을 계속 생성하여 coins에 넣는다.
		while(machineMoneyLeft > 0){
			Coin coin = makeRandomCoin();
			if(coin.getAmount() <= machineMoneyLeft){
				coins.put(coin, coins.getOrDefault(coin, 0) + 1);
				machineMoneyLeft -= coin.getAmount();
			}
		}
		return coins;
	}

	private Coin makeRandomCoin(){
		List<Integer> coinList = makeCoinListByEnum();
		int coinAmount = Randoms.pickNumberInList(coinList);
		return Coin.findByAmount(coinAmount);
	}

	private List<Integer> makeCoinListByEnum(){
		return Arrays.stream(Coin.values())
			.map(Coin::getAmount)
			.collect(Collectors.toList());
	}
}
