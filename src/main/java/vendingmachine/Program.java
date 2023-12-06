package vendingmachine;

import java.util.Map;

import vendingmachine.View.InputView;
import vendingmachine.View.OutputView;

public class Program {
	CoinsMaker coinsMaker;
	ProductsMaker productsMaker;

	public Program(CoinsMaker coinsMaker, ProductsMaker productsMaker){
		this.coinsMaker = coinsMaker;
		this.productsMaker = productsMaker;
	}
	public void run(){
		int machineMoney = Integer.parseInt(InputView.getMachineMoney());
		Map<Coin, Integer> coins = coinsMaker.makeCoins(machineMoney);
		OutputView.printMachineCoins(coins);

		String productsInput = InputView.getMachineProducts();
	}

}
