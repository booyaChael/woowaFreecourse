import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import domain.Menu;
import domain.MenuRepository;
import domain.Store;
import domain.TableRepository;
import domain.Table;

public class StoreTest {
	//findTableByNumber
	// 테이블 번호 1~8에 대해서 findTableByNumber은 알맞은 Table을 반환해야 한다.
	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3, 5, 6, 8})
	void findTableByValidNumberTest(int validTableNumber) {
		Store store = new Store(TableRepository.tables(), MenuRepository.menus());

		Table foundTable = store.findTableByNumber(validTableNumber);

		assertNotNull(foundTable);
		assertEquals(validTableNumber, foundTable.getNumber());
	}

	// 그외의 테이블 번호에 대해서 findTableByNumber은 Exception을 반환해야 한다.
	@Test
	void findTableByInvalidNumberTest() {
		Store store = new Store(TableRepository.tables(), MenuRepository.menus());

		int invalidTableNumber = 10;
		assertThrows(IllegalArgumentException.class, () -> {
			store.findTableByNumber(invalidTableNumber);
		});
	}

	//findMenuByNumber
	// 메뉴번호 1,2,3,4,5,6,21,22에 대해서 findMenuByNumber은 알맞은 Menu를 반환해야 한다.
	@ParameterizedTest
	@ValueSource(ints = {1,2,3,4,5,6,21,22})
	void findMenuByValidNumberTest(int validMenuNumber) {
		Store store = new Store(TableRepository.tables(), MenuRepository.menus());

		Menu foundMenu = store.findMenuByNumber(validMenuNumber);

		assertNotNull(foundMenu);
		assertEquals(validMenuNumber, foundMenu.getNumber());
	}

	// 그외의 메뉴번호에 대해서 findMenuByNumber은 Exception을 반환해야 한다.
	void findMenuByInvalidNumberTest() {
		Store store = new Store(TableRepository.tables(), MenuRepository.menus());

		int invalidMenuNumber = 10;
		assertThrows(IllegalArgumentException.class, () -> {
			store.findMenuByNumber(invalidMenuNumber);
		});
	}

}
