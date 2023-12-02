package domain;

import view.InputView;
import view.OutputView;

public class PayManager {
	public void run(Store store){
		OutputView.printTables(store.getTables());
		int tableNumber = InputView.inputTableNumber();
		Table table = store.findTableByNumber(tableNumber);

		OutputView.printOrder(table.getOrder());


	};
}
