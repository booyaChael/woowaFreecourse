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
		while(true){
			try{
				OutputView.printMainFunction();
				String functionSelect = InputView.getFunctionSelectInput();
				if(functionSelect.equals("1")){
					stationManager.run();
				}
				if(functionSelect.equals("2")){
					lineManager.run();
				}
				if(functionSelect.equals("3")){
					sectionManager.run();
				}
				if(functionSelect.equals("Q")){
					return;
				}
				throw new IllegalArgumentException("[ERROR] 올바른 입력값이 아닙니다.");
			} catch(IllegalArgumentException e){
				System.out.println(e.getMessage());
			}
		}
	}
}
