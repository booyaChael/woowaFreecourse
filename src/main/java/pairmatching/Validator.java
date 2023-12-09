package pairmatching;

import pairmatching.Domain.Mission;

public class Validator {
	static public void checkMissionExists(Mission mission){
		if(mission == null){
			throw new IllegalArgumentException("[ERROR] 존재하지 않는 미션입니다. 다시 입력해주세요.");
		}
	}
}
