package subway;

import subway.Service.LineManager;
import subway.Service.SectionManager;
import subway.Service.StationManager;
import subway.View.InputView;
import subway.View.OutputView;

public class Program {
	final private LineManager lineManager;
	final private StationManager stationManager;
	final private SectionManager sectionManager;
	public Program(StationManager stationManager, LineManager lineManager, SectionManager sectionManager){
		this.stationManager = stationManager;
		this.lineManager = lineManager;
		this.sectionManager = sectionManager;
	}

	public void run(){
		OutputView.printMainFunction();
		int functionSelect = InputView.getFunctionSelectInput();
		if(functionSelect == 1){
			stationManager.run();
		}
		if(functionSelect == 2){
			lineManager.run();
		}
		if(functionSelect == 3){
			sectionManager.run();
		}
	}
}
