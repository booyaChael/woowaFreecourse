import domain.Menu;
import domain.MenuRepository;
import domain.OrderManager;
import domain.PayManager;
import domain.Program;
import domain.Store;
import domain.Table;
import domain.TableRepository;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Application {
    // TODO 구현 진행
    public static void main(String[] args) {
        OrderManager orderManager = new OrderManager();
        PayManager payManager = new PayManager();
        Store store = new Store(TableRepository.tables(), MenuRepository.menus());

        Program program = new Program(store, orderManager, payManager);
        program.run();
    }
}
