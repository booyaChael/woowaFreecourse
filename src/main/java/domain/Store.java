//Store.java
package domain;

import java.util.List;

public class Store {
	private List<Table> tables;
	private List<Menu> menus;
	private DiscountEvent discountEvent;

	public Store(List<Table> tables, List<Menu> menus){
		this.tables = tables;
		this.menus = menus;
		this.discountEvent = new DiscountEvent();
	}

	public List<Table> getTables(){
		return this.tables;
	}

	public List<Menu> getMenus(){
		return this.menus;
	}

	public DiscountEvent getDiscountEvent(){ return this.discountEvent;}

	public Table findTableByNumber(int tableNumber){
		for(Table table : tables){
			if(table.getNumber() == tableNumber){
				return table;
			}
		}
		return null;
	}

	public Menu findMenuByNumber(int menuNumber){
		for(Menu menu : menus){
			if(menu.getNumber() == menuNumber){
				return menu;
			}
		}
		return null;
	}

}
