package domain;

import view.InputView;
import view.OutputView;

public class Program {
	private Store store;
	private OrderManager orderManager;
	private PayManager payManager;

	public Program(Store store, OrderManager orderManager, PayManager payManager) {
		this.store = store;
		this.orderManager = orderManager;
		this.payManager = payManager;
	}

	public void run() {
		OutputView.printMain();
		int functionNumber = InputView.inputFunctionNumber();

		if(functionNumber == 1){
			orderManager.run(store);
		}
		if(functionNumber == 2){
			payManager.run();
		}
	};

}

