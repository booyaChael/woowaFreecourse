package domain;

import java.util.Map;

import view.InputView;
import view.OutputView;

public class PayManager {
	public void run(Store store){
		OutputView.printTables(store.getTables());
		int tableNumber = InputView.inputTableNumber();
		Table table = store.findTableByNumber(tableNumber);

		Map<Menu, Integer> order = table.getOrder();

		OutputView.printOrder(order);
		int payWayNumber = InputView.inputPayWay(tableNumber);

		int totalPrice = calculateTotalPrice(order);
		int priceDiscountedByOrderEvent = store.getDiscountEvent().discountByChicken_10(order, totalPrice);
		double priceDiscountByPayEvent = store.getDiscountEvent().discountByPay_Money(payWayNumber, priceDiscountedByOrderEvent);
		OutputView.printPriceToPay((int) Math.round(priceDiscountByPayEvent));
	};

	private int calculateTotalPrice(Map<Menu, Integer> order){
		int totalPrice = 0;
		for (Map.Entry<Menu, Integer> entry : order.entrySet()) {
			Menu menu = entry.getKey();
			int count = entry.getValue();
			int menuPrice = menu.getPrice();
			totalPrice += menuPrice * count;
		}
		return totalPrice;
	}
}
