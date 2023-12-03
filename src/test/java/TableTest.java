import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import domain.Category;
import domain.Menu;
import domain.Table;

public class TableTest {
	@Test
	void addOrderTest(){Map<Menu, Integer> order = new HashMap<>();
		Menu menu = new Menu(1, "치킨", Category.CHICKEN, 20_000);
		order.put(menu, 99);
		Table table = new Table(1, order);

		assertThrows(IllegalArgumentException.class, () -> {
			table.addOrder(menu, 2);
		});
	}
}
