import domain.MenuRepository;
import Service.OrderManager;
import Service.PayManager;
import domain.Store;
import domain.TableRepository;

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
