package domain;

import java.util.List;

public class Store {
	List<Table> tables;
	List<Menu> menus;

	public Store(List<Table> tables, List<Menu> menus){
		this.tables = tables;
		this.menus = menus;
	}

	public List<Table> getTables(){
		return this.tables;
	}

	public List<Menu> getMenus(){
		return this.menus;
	}
}
