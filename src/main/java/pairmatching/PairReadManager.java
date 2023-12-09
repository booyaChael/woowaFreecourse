package pairmatching;

import pairmatching.Domain.Mission;
import pairmatching.Domain.MissionRepository;
import pairmatching.Domain.PairsRepository;
import pairmatching.View.InputView;
import pairmatching.View.OutputView;

public class PairReadManager {
	public void run(){
		String input = InputView.getCourseLevelMission();
		Mission mission = MissionRepository.findMissionByInput(input);
		OutputView.printPairs(PairsRepository.getPairs(mission));
	}
}
