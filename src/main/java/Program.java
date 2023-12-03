import Service.OrderManager;
import Service.PayManager;
import domain.Store;
import view.InputView;
import view.OutputView;
import util.Constants;

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
		while(true){
			OutputView.printMain();
			int function = readFunction();

			if(function == Constants.FUNCTION_ORDER){
				orderManager.run(store);
			}
			if(function == Constants.FUNCTION_PAY){
				payManager.run(store);
			}
			if(function == Constants.FUNCTION_QUIT){
				return;
			}
		}
	};

	private int readFunction(){
		while(true){
			try{
				int functionNumber = InputView.inputFunctionNumber();
				validateFunctionNumber(functionNumber);
				return functionNumber;
			} catch(IllegalArgumentException e){
				System.out.println(e.getMessage());
			}
		}
	}

	private void validateFunctionNumber(int functionNumber){
		if(functionNumber < Constants.FUNCTION_ORDER || functionNumber > Constants.FUNCTION_QUIT){
			throw new IllegalArgumentException("[ERROR] 올바른 입력값이 아닙니다."+Constants.FUNCTION_ORDER+"과 "+Constants.FUNCTION_QUIT+" 사이의 숫자로 입력해주세요.");
		}
	}

}

