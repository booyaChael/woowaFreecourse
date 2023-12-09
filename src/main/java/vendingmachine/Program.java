package vendingmachine;

import java.util.Map;

import vendingmachine.View.InputView;
import vendingmachine.View.OutputView;

public class Program {
	public void run(){
		Money machineMoney = readMachineMoney();
		Map<Coin, Integer> coins = machineMoney.makeCoins();
		OutputView.printMachineCoins(coins);

		VendingInventory vendingInventory = readInventory();
		VendingMachine vendingMachine = new VendingMachine(machineMoney, vendingInventory);
		vendingMachine.takeOrder();
	}

	private Money readMachineMoney(){
		while(true){
			try{
				String input = InputView.getMachineMoney();
				return new Money(input);
			} catch(IllegalArgumentException e){
				System.out.println(e.getMessage());
			}
		}
	}

	private VendingInventory readInventory(){
		while(true){
			try{
				String input = InputView.getMachineProducts();
				return new VendingInventory(input);
			} catch(IllegalArgumentException e){
				System.out.println(e.getMessage());
			}
		}
	}

}
