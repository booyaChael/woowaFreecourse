//Table.java
package domain;

import java.util.HashMap;
import java.util.Map;

public class Table {
    private final int number;
    private Map<Menu, Integer> order;

    public Table(final int number) {

        this.number = number;
        this.order = new HashMap<>();
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }

    public int getNumber(){
        return this.number;
    }
    public void addOrder(Menu menu, int count){
        int currentCount = order.getOrDefault(menu, 0);
        order.put(menu, currentCount + count);
        System.out.println(menu.getName());
        System.out.println(count);
    }

    public Map<Menu, Integer> getOrder(){
        return this.order;
    }
}
