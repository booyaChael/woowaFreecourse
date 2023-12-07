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
		int machineMoney = readMachineMoney();
		Map<Coin, Integer> coins = coinsMaker.makeCoins(machineMoney);
		OutputView.printMachineCoins(coins);

		Map<Product, Integer> products = productsMaker.makeProducts(InputView.getMachineProducts());
		VendingMachine vendingMachine = new VendingMachine(machineMoney, coins, products);
		vendingMachine.takeOrder();
	}

	private int readMachineMoney(){
		while(true){
			try{
				String input = InputView.getMachineMoney();
				validateMachineMoney(input);
				return Integer.parseInt(input);
			} catch(IllegalArgumentException e){
				System.out.println(e.getMessage());
			}
		}
	}

	private void validateMachineMoney(String input){
		Validator.checkIsNumber(input);

		int machineMoney = Integer.parseInt(input);
		Validator.checkIsDividedBy10(machineMoney);
		Validator.checkOver100(machineMoney);
	}

}
