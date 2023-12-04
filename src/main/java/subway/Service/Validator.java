package subway.Service;

import subway.domain.LineRepository;
import subway.domain.StationRepository;

public class Validator {
	static public void newStationShouldHasUniqueName(String stationName){
		if(StationRepository.getStationByName(stationName) != null){
			throw new IllegalArgumentException("[ERROR] 이미 존재하는 역 이름입니다. 다시 입력해주세요.");
		}
	}

	static public void lengthShouldBeOver_2(String name){
		if(name.length() < 2){
			throw new IllegalArgumentException("[ERROR] 2글자 이상이어야 합니다. 다시 입력해주세요.");
		}
	}

	static public void stationShouldExist(String stationName){
		if(StationRepository.getStationByName(stationName) == null){
			throw new IllegalArgumentException("[ERROR] 입력하신 역이 존재하지 않습니다. 다시 입력해주세요.");
		}
	}

	static public void lineShouldHasUniqueName(String lineName){
		if(LineRepository.getLineByName(lineName) != null){
			throw new IllegalArgumentException("[ERROR] 이미 존재하는 노선 이름입니다. 다시 입력해주세요.");
		}
	}
}
