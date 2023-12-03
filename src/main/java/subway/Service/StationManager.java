//StationManager.java
package subway.Service;

import subway.View.InputView;
import subway.View.OutputView;
import subway.domain.Station;
import subway.domain.StationRepository;

public class StationManager {
	public void run(){
		OutputView.printStationFunction();
		int function = InputView.getFunctionSelectInput();
		if(function == 1){
			registerStation();
		}
		if(function == 2){

		}
	}

	private void registerStation(){
		while(true){
			try{
				String stationName = InputView.getStationToRegisterInput();
				validateStationName(stationName);
				StationRepository.addStation(new Station(stationName));
				OutputView.printStationRegisteredSuccess();
				break;
			} catch(IllegalArgumentException e){
				System.out.println(e.getMessage());
			}
		}
	}

	private void validateStationName(String stationName){
		if(StationRepository.getStationByName(stationName) != null){
			throw new IllegalArgumentException("[ERROR] 이미 존재하는 역 이름입니다. 다시 입력해주세요.");
		}
		if(stationName.length() < 2){
			throw new IllegalArgumentException("[ERROR] 역 이름은 2글자 이상이어야 합니다. 다시 입력해주세요.");
		}
	}
}
