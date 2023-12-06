// VendingMachine.java
package vendingmachine;

import java.util.Map;

import vendingmachine.View.InputView;
import vendingmachine.View.OutputView;

	public class VendingMachine {
		private int machineMoney;
		private int userMoney;
		private Map<Coin, Integer> machineCoins;
		private Map<Product, Integer> products;

		public VendingMachine(int machineMoney, Map<Coin, Integer> machineCoins, Map<Product, Integer> products){
			this.machineMoney = machineMoney;
			this.machineCoins = machineCoins;
			this.products = products;
		}

		public void takeOrder(){
			this.userMoney = Integer.parseInt(InputView.getUserMoney());
			buy();

		}

		private void buy(){
			while(true){
				try{
					OutputView.printUserMoneyLeft(userMoney);
					String productName = InputView.getProductToBuy();
					Product product = findProductByName(productName);
					buyProduct(product);

					if(findLowestPriceOfCurrentProducts() > userMoney || isNoProductLeft()){
						break;
					}

				} catch(IllegalArgumentException e){
					System.out.println(e.getMessage());
				}
			}
		}

		private Product findProductByName(String productName) {
			for (Map.Entry<Product, Integer> entry : products.entrySet()) {
				Product product = entry.getKey();
				System.out.println(product.getName());
				if (productName.equals(product.getName())) {
					return product;
				}
			}
			return null;
		}

		//현재 수량이 남아있는 Products에 대해서 가장 낮은 가격을 반환한다
		private int findLowestPriceOfCurrentProducts() {
			int lowestPrice = Integer.MAX_VALUE;
			for (Map.Entry<Product, Integer> entry : products.entrySet()) {
				Product product = entry.getKey();
				int currentPrice = product.getPrice();
				int quantity = entry.getValue();

				if (quantity >= 1 && currentPrice < lowestPrice) {
					lowestPrice = currentPrice;
				}
			}
			return lowestPrice;
		}

		private boolean isNoProductLeft(){
			for (Map.Entry<Product, Integer> entry : products.entrySet()) {
				if (entry.getValue() != 0) {
					return false;
				}
			}
			return true;
		}

		private void buyProduct(Product product){
			if (!products.containsKey(product)) {
				throw new IllegalArgumentException("[ERROR] 자판기에 존재하지 않는 상품입니다.");
			}
			int currentQuantity = products.get(product);
			if(currentQuantity < 1) {
				throw new IllegalArgumentException("[ERROR] 재고가 부족합니다.");
			}
			products.put(product, currentQuantity - 1);
			userMoney -= product.getPrice();
		}



}
