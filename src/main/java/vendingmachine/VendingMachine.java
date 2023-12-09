// VendingMachine.java
package vendingmachine;

import java.util.HashMap;
import java.util.Map;

import vendingmachine.View.InputView;
import vendingmachine.View.OutputView;

	public class VendingMachine {
		private Money machineMoney;
		private VendingInventory vendingInventory;

		public VendingMachine(Money machineMoney, VendingInventory vendingInventory){
			this.machineMoney = machineMoney;
			this.vendingInventory = vendingInventory;
		}

		public void takeOrder(){
			Money userMoney = readUserMoney();
			while(true){
				OutputView.printUserMoneyLeft(userMoney);
				Product product = readProductToBuy(userMoney);
				int price = buyProduct(product);
				userMoney.decrease(price);

				int lowestPrice = vendingInventory.findLowestPriceOfCurrentProducts();
				if(userMoney.isLessThan(lowestPrice)){
					break;
				}
			}
			Map<Coin, Integer> change =machineMoney.makeCoinsByAmount(userMoney.getMoney());
			OutputView.printChange(change);
		}

		private Money readUserMoney(){
			while(true){
				try{
					String input = InputView.getUserMoney();
					return new Money(input);
				} catch(IllegalArgumentException e){
					System.out.println(e.getMessage());
				}
			}
		}

		private Product readProductToBuy(Money userMoney){
			while(true){
				try{
					String productName = InputView.getProductToBuy();
					return vendingInventory.checkAvailableProduct(productName, userMoney);
				} catch(IllegalArgumentException e){
					System.out.println(e.getMessage());
				}
			}
		}
		private int buyProduct(Product product){
			return vendingInventory.takeProduct(product);
		}
}
