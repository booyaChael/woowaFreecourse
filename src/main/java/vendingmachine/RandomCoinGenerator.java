package vendingmachine;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomCoinGenerator {

	static public Coin makeRandomCoin(){
		List<Integer> coinList = makeCoinListByEnum();
		int coinAmount = Randoms.pickNumberInList(coinList);
		return Coin.findByAmount(coinAmount);
	}

	static public List<Integer> makeCoinListByEnum(){
		return Arrays.stream(Coin.values())
			.map(Coin::getAmount)
			.collect(Collectors.toList());
	}
}
