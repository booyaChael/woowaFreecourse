//Table.java
package domain;

import java.util.HashMap;
import java.util.Map;

import util.Constants;

public class Table {
    private final int number;
    private Map<Menu, Integer> order;

    public Table(final int number) {
        this.number = number;
        this.order = new HashMap<>();
    }

    public Table(int number, Map<Menu, Integer> order){
        this.number = number;
        this.order = order;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }

    public int getNumber(){
        return this.number;
    }
    public void addOrder(Menu menu, int count){
        validateOrder(menu, count);
        int currentCount = order.getOrDefault(menu, 0);
        order.put(menu, currentCount + count);
    }

    public Map<Menu, Integer> getOrder(){
        return this.order;
    }

    private void validateOrder(Menu menu, int count){
        int totalCountOfMenu = this.order.get(menu) + count;
        if(totalCountOfMenu > Constants.MAX_ORDER_MENU){
            throw new IllegalArgumentException("[ERROR] 한 테이블당 하나의 메뉴에 대해"+ Constants.MAX_ORDER_MENU +"개까지만 주문이 가능합니다. 다시 입력해주세요.");
        }
    }
}
