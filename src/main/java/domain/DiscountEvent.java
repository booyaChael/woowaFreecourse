package domain;

import java.util.Map;

public class DiscountEvent {
	public int discountByChicken_10(Map<Menu, Integer> order, int totalPrice){
		int totalChickenCount = 0;
		for (Menu menu : order.keySet()) {
			if (menu.getCategory() == Category.CHICKEN) {
				totalChickenCount += order.get(menu);
			}
		}
		int discountPrice = (totalChickenCount / 10) * 10_000;
		return totalPrice - discountPrice;
	}

	public double discountByPay_Money(int payway, int totalPrice){
		System.out.println(totalPrice);
		if(payway == 2){
			System.out.println("IT's 현금");
			System.out.println(totalPrice * 0.95);
			return totalPrice * 0.95;
		}
		return totalPrice;
	}

}
