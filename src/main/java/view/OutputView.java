package view;

import domain.Menu;
import domain.Table;

import java.util.List;
import java.util.Map;

public class OutputView {
    private static final String TOP_LINE = "┌ ─ ┐";
    private static final String TABLE_FORMAT = "| %s |";
    private static final String BOTTOM_LINE = "└ ─ ┘";

    public static void printMain(){
        System.out.println("## 메인화면\n"
            + "1 - 주문등록\n"
            + "2 - 결제하기\n"
            + "3 - 프로그램 종료\n");
    }

    public static void printTables(final List<Table> tables) {
        System.out.println("## 테이블 목록");
        final int size = tables.size();
        printLine(TOP_LINE, size);
        printTableNumbers(tables);
        printLine(BOTTOM_LINE, size);
    }

    public static void printMenus(final List<Menu> menus) {
        for (final Menu menu : menus) {
            System.out.println(menu);
        }
    }

    public static void printOrder(Map<Menu, Integer> order){
        System.out.println("## 주문 내역");
        System.out.printf("%-10s %-5s %-5s%n", "메뉴", "수량", "금액");

        for (Map.Entry<Menu, Integer> entry : order.entrySet()) {
            Menu menu = entry.getKey();
            int count = entry.getValue();
            int totalPrice = menu.getPrice() * count;

            System.out.printf("%-10s %-5d %-5d%n", menu.getName(), count, totalPrice);
        }
    }

    public static void printPriceToPay(int price){
        System.out.println("## 최종 결제할 금액");
        System.out.printf("%d원\n", price);
    }

    private static void printLine(final String line, final int count) {
        for (int index = 0; index < count; index++) {
            System.out.print(line);
        }
        System.out.println();
    }

    private static void printTableNumbers(final List<Table> tables) {
        for (final Table table : tables) {
            System.out.printf(TABLE_FORMAT, table);
        }
        System.out.println();
    }
}
