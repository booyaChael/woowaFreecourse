package domain;

import view.InputView;
import view.OutputView;

public class OrderManager {
	public void run(Store store){
		OutputView.printTables(store.getTables());
		int tableNumber = InputView.inputTableNumber();
		OutputView.printMenus(store.getMenus());
		int menuNumber = InputView.inputMenuNumber();
		int menuCount =


	};
}
