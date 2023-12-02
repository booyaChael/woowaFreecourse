//OrderManager.java
package domain;

import view.InputView;
import view.OutputView;

public class OrderManager {
	public void run(Store store){
		OutputView.printTables(store.getTables());
		int tableNumber = InputView.inputTableNumber();
		Table table = store.findTableByNumber(tableNumber);

		OutputView.printMenus(store.getMenus());

		int menuNumber = InputView.inputMenuNumber();
		Menu menu = store.findMenuByNumber(menuNumber);

		int menuCount = InputView.inputMenuCount();
		table.addOrder(menu, menuCount);
	};
}
