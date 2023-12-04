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
				String function = InputView.getFunctionSelectInput();
				if(function.equals("1")){
					registerLine();
				}
				if(function.equals("2")){
					deleteLine();
				}
				if(function.equals("3")){
					readLines();
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
				String lineName = InputView.getLineToRegisterInput();
				validateLineNameToRegister(lineName);

				String startStationName = InputView.getStartStationOfLineInput();
				validateStartStation(startStationName);
				Station startStation = StationRepository.getStationByName(startStationName);

				String endStationName = InputView.getEndStationOfLineInput();
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
				String lineName = InputView.getLineToDeleteInput();
				validateDelete(lineName);
				LineRepository.deleteLineByName(lineName);
				break;
			} catch(IllegalArgumentException e){
				System.out.println(e.getMessage());
			}
		}
	}

	private void readLines(){
		OutputView.printAllLines(LineRepository.lines());
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
