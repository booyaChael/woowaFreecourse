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
	public Program(LineManager lineManager, StationManager stationManager, SectionManager sectionManager){
		this.lineManager = lineManager;
		this.stationManager = stationManager;
		this.sectionManager = sectionManager;
	}

	public void run(){
		OutputView.printMainFunction();
		int functionSelect = InputView.getFunctionSelectInput();

	}
}
