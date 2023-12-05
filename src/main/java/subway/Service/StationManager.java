//StationManager.java
package subway.Service;

import subway.View.InputView;
import subway.View.OutputView;
import subway.domain.Station;
import subway.domain.StationRepository;

public class StationManager {
	public void run(){
		OutputView.printStationFunction();
		String function = InputView.getFunctionSelect();
		if(function.equals("1")){
			registerStation();
			return;
		}
		if(function.equals("2")){
			deleteStation();
			return;
		}
		if(function.equals("3")){
			readStations();
			return;
		}
		if(function.equals("B")){
			return;
		}
		throw new IllegalArgumentException("[ERROR] 올바른 입력값이 아닙니다.");
	}

	private void registerStation(){
		while(true){
			try{
				String stationName = InputView.getStationToRegister();
				validateRegister(stationName);
				StationRepository.addStation(new Station(stationName));
				OutputView.printStationRegisteredSuccess();
				break;
			} catch(IllegalArgumentException e){
				System.out.println(e.getMessage());
			}
		}
	}

	private void deleteStation(){
		while(true){
			try{
				String stationName = InputView.getStationToDelete();
				validateDelete(stationName);
				StationRepository.deleteStation(stationName);
				break;
			} catch(IllegalArgumentException e){
				System.out.println(e.getMessage());
			}
		}
	}

	private void readStations(){
		OutputView.printAllStations(StationRepository.stations());
	}

	private void validateRegister(String stationName){
		Validator.newStationShouldHasUniqueName(stationName);
		Validator.lengthShouldBeOver_2(stationName);
	}

	private void validateDelete(String stationName){
		Validator.stationShouldExist(stationName);
	}
}
