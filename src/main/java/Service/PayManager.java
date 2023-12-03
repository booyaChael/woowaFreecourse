package Service;

import java.util.Map;

import domain.DiscountEvent;
import domain.Menu;
import domain.Store;
import domain.Table;
import util.Constants;
import view.InputView;
import view.OutputView;

public class PayManager {
	public void run(Store store){
		Table table = readTableNumber(store);

		OutputView.printOrder(table.getOrder());

		int payWayNumber = readPayWay(table.getNumber());

		int discountedPrice = calculateDiscountedPrice(table.getOrder(), store.getDiscountEvent(), payWayNumber);

		OutputView.printPriceToPay(discountedPrice);
	};

	private Table readTableNumber(Store store){
		while(true){
			try{
				OutputView.printTables(store.getTables());
				int tableNumber = InputView.inputTableNumber();
				return store.findTableByNumber(tableNumber);
			} catch(IllegalArgumentException e){
				System.out.println(e.getMessage());
			}
		}
	}

	private int readPayWay(int tableNumber){
		while(true){
			try{
				int payWayNumber = InputView.inputPayWay(tableNumber);
				validatePayWayNumber(payWayNumber);
				return payWayNumber;
			} catch(IllegalArgumentException e){
				System.out.println(e.getMessage());
			}
		}
	}

	private int calculateDiscountedPrice(Map<Menu, Integer> order, DiscountEvent discountEvent, int payWayNumber){
		int totalPrice = calculateTotalPrice(order);
		int priceDiscountedByOrderEvent = discountEvent.discountByChicken_10(order, totalPrice);
		double priceDiscountByPayEvent = discountEvent.discountByPay_Money(payWayNumber, priceDiscountedByOrderEvent);
		return (int) Math.round(priceDiscountByPayEvent);
	}

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

	private void validatePayWayNumber(int payWayNumber){
		if(payWayNumber != Constants.PAY_CREDIT_CARD && payWayNumber != Constants.PAY_MONEY){
			throw new IllegalArgumentException("[ERROR] 1 또는 2로 다시 입력해주세요.");
		}
	}
}
