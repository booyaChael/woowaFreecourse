//PairMatchManager.java
package pairmatching;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.Domain.Crew;
import pairmatching.Domain.CrewRepository;
import pairmatching.Domain.Course;
import pairmatching.Domain.Level;
import pairmatching.Domain.Mission;
import pairmatching.Domain.MissionRepository;
import pairmatching.Domain.Pair;
import pairmatching.Domain.PairsRepository;
import pairmatching.View.InputView;
import pairmatching.View.OutputView;

public class PairMatchManager {
	public void run(){
		Mission mission = readMission();
		if(isDataExists(mission)){
			boolean isChangeData = readIsChangeData();
			if(!isChangeData){
				return;
			}
		}
		List<Pair> pairs = makePairs(mission);
		OutputView.printPairs(pairs);
		PairsRepository.addPairs(mission, pairs);
	}

	private Mission readMission(){
		while(true){
			try{
				String input = InputView.getCourseLevelMission();
				Mission mission = MissionRepository.findMissionByInput(input);
				Validator.checkMissionExists(mission);
				return mission;
			} catch(IllegalArgumentException e){
				System.out.println(e.getMessage());
			}
		}
	}

	private boolean isDataExists(Mission mission){
		return PairsRepository.getPairsByMission(mission) != null;
	}

	private boolean readIsChangeData(){
		boolean result = false;
		while(true){
			try{
				String input = InputView.getIsChangeData();
				if(input.equals("네")){
					result = true;
				}
				if(input.equals("아니오")){
					result = false;
				}
				return result;
			}catch(IllegalArgumentException e){
				System.out.println(e.getMessage());
			}
		}
	}

	private List<Pair> makePairs(Mission mission) {
		while (true) {
			List<String> shuffledCrewNames = getShuffledCrewNames(mission.getCourse());
			List<Pair> pairs = createPairs(shuffledCrewNames);

			if (!PairsRepository.haveSamePairInSameLevel(mission, pairs)) {
				return pairs;
			}
		}
	}

	private List<Pair> createPairs(List<String> shuffledCrewNames) {
		List<Pair> pairs = new ArrayList<>();
		for (int i = 0; i < shuffledCrewNames.size(); i += 2) {
			Crew firstCrew = CrewRepository.getCrewByName(shuffledCrewNames.get(i));
			Crew secondCrew = CrewRepository.getCrewByName(shuffledCrewNames.get(i + 1));

			if (i + 2 == shuffledCrewNames.size() - 1) {
				Crew thirdCrew = CrewRepository.getCrewByName(shuffledCrewNames.get(i + 2));
				pairs.add(new Pair(firstCrew, secondCrew, thirdCrew));
				break;
			}
			pairs.add(new Pair(firstCrew, secondCrew));
		}
		return pairs;
	}


	private List<String> getShuffledCrewNames(Course course){
		List<String> crewNames = CrewRepository.getCrewNamesByCourse(course);
		return Randoms.shuffle(crewNames);
	}

}
