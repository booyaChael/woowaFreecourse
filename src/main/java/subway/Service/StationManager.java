package subway.Service;

import subway.View.InputView;
import subway.View.OutputView;

public class StationManager {
	public void run(){
		OutputView.printStationFunction();
		int function = InputView.getFunctionSelectInput();
	}
}
