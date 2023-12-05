package subway.Service;

import subway.View.InputView;
import subway.View.OutputView;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

public class LineManager {
	public void run(){
		while(true){
			try{
				OutputView.printLineFunction();
				String function = InputView.getFunctionSelect();
				if(function.equals("1")){
					registerLine();
					return;
				}
				if(function.equals("2")){
					deleteLine();
					return;
				}
				if(function.equals("3")){
					readLines();
					return;
				}
				if(function.equals("B")){
					return;
				}
				throw new IllegalArgumentException("[ERROR] 올바른 입력값이 아닙니다.");
			} catch(IllegalArgumentException e){
				System.out.println(e.getMessage());
			}
		}
	}

	private void registerLine(){
		while(true){
			try{
				String lineName = InputView.getLineToRegister();
				validateLineNameToRegister(lineName);

				String startStationName = InputView.getStartStationOfLine();
				validateStartStation(startStationName);
				Station startStation = StationRepository.getStationByName(startStationName);

				String endStationName = InputView.getEndStationOfLine();
				validateEndStation(endStationName);
				Station endStation = StationRepository.getStationByName(endStationName);

				LineRepository.addLine(new Line(lineName, startStation, endStation));
				break;
			}catch(IllegalArgumentException e){
				System.out.println(e.getMessage());
			}
		}
	};

	private void deleteLine(){
		while(true){
			try{
				String lineName = InputView.getLineToDelete();
				validateDelete(lineName);
				LineRepository.deleteLineByName(lineName);
				break;
			} catch(IllegalArgumentException e){
				System.out.println(e.getMessage());
			}
		}
	}

	private void readLines(){
		try{
			OutputView.printAllLines(LineRepository.lines());
		} catch(IllegalArgumentException e){
			System.out.println(e.getMessage());
		}
	}

	private void validateLineNameToRegister(String lineName){
		Validator.lineShouldHasUniqueName(lineName);
		Validator.lengthShouldBeOver_2(lineName);
	}

	private void validateStartStation(String startStation){
		Validator.stationShouldExist(startStation);
	}

	private void validateEndStation(String endStation){
		Validator.stationShouldExist(endStation);
	}

	private void validateDelete(String lineName){
		Validator.stationShouldExist(lineName);
	}
}
