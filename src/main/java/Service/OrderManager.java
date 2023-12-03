//OrderManager.java
package Service;

import java.util.List;
import java.util.Map;

import domain.Menu;
import domain.Store;
import domain.Table;
import view.InputView;
import view.OutputView;

public class OrderManager {
	public void run(Store store){
		Table table = readTableNumber(store);
		Menu menu = readMenu(store);
		readMenuCountAndAddOrder(table, menu);
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

	private Menu readMenu(Store store){
		while(true){
			try{
				OutputView.printMenus(store.getMenus());
				int menuNumber = InputView.inputMenuNumber();
				return store.findMenuByNumber(menuNumber);
			} catch(IllegalArgumentException e){
				System.out.println(e.getMessage());
			}
		}
	}

	private void readMenuCountAndAddOrder(Table table, Menu menu){
		while(true){
			try{
				int count = InputView.inputMenuCount();
				table.addOrder(menu, count);
			} catch(IllegalArgumentException e){
				System.out.println(e.getMessage());
			}
		}
	}


}
