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
		String input = InputView.getCourseLevelMission();
		List<Pair> pairs = makePairs();
		OutputView.printPairs(pairs);
		Mission mission = findMissionByInput(input);
		PairsRepository.addPairs(mission, pairs);
	}

	private List<Pair> makePairs(){
		List<String> crewNames = CrewRepository.getCrewNamesByCourse(Course.BACKEND);
		List<String> shuffledCrewNames = Randoms.shuffle(crewNames);
		List<Pair> pairs = new ArrayList<>();
		for(int i = 1; i < shuffledCrewNames.size(); i += 2){
			Pair pair = new Pair(CrewRepository.getCrewByName(shuffledCrewNames.get(i-1)), CrewRepository.getCrewByName(shuffledCrewNames.get(i)));
			pairs.add(pair);
		}
		return pairs;
	}

	private Mission findMissionByInput(String input) {
		String[] parts = input.split(", ");
		if(parts.length != 3){
			throw new IllegalArgumentException("[ERROR] 올바른 입력형식이 아닙니다.");
		}

		Course course = null;
		Level level= null;
		String missionName;

		String courseInput = parts[0];
		for(Course currentCourse : Course.values()){
			if(courseInput.equals(currentCourse.getName())){
				course = currentCourse;
			}
		}

		String levelInput = parts[1];
		for(Level currentLevel : Level.values()){
			if(levelInput.equals(currentLevel.getName())){
				level = currentLevel;
			}
		}

		missionName = parts[2];
		return MissionRepository.getMission(course, level, missionName);
	}


}
