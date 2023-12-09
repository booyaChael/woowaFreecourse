package pairmatching.Domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MissionRepository {
	private static final List<Mission> missions = new ArrayList<>();

	public static void addMission(Course course, Level level, String missionName){
		missions.add(new Mission(course, level, missionName));
	}

	static public Mission findMissionByInput(String input) {
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
		return getMission(course, level, missionName);
	}

	public static List<Mission> findMissionsWithSameCourseAndLevel(Mission mission){
		Course course = mission.getCourse();
		Level level = mission.getLevel();

		List<Mission> result = new ArrayList<>();
		for(Mission currentMission : missions){
			if(currentMission.getCourse() == course && currentMission.getLevel() == level){
				result.add(currentMission);
			}
		}
		return result;
	}
	public static Mission getMission(Course course, Level level, String missionName) {
		Optional<Mission> matchingMission = missions.stream()
			.filter(mission ->
				mission.getCourse() == course &&
					mission.getLevel() == level &&
					mission.getMissionName().equals(missionName))
			.findFirst();

		return matchingMission.orElse(null);
	}

	static {
		missions.add(new Mission(Course.BACKEND, Level.LEVEL1, "자동차경주"));
		missions.add(new Mission(Course.BACKEND, Level.LEVEL1, "로또"));
		missions.add(new Mission(Course.BACKEND, Level.LEVEL1, "숫자야구게임"));

		missions.add(new Mission(Course.BACKEND, Level.LEVEL2, "장바구니"));
		missions.add(new Mission(Course.BACKEND, Level.LEVEL2, "결제"));
		missions.add(new Mission(Course.BACKEND, Level.LEVEL2, "지하철노선도"));

		missions.add(new Mission(Course.BACKEND, Level.LEVEL4, "성능개선"));
		missions.add(new Mission(Course.BACKEND, Level.LEVEL4, "배포"));

		missions.add(new Mission(Course.FRONTEND, Level.LEVEL1, "자동차경주"));
		missions.add(new Mission(Course.FRONTEND, Level.LEVEL1, "로또"));
		missions.add(new Mission(Course.FRONTEND, Level.LEVEL1, "숫자야구게임"));

		missions.add(new Mission(Course.FRONTEND, Level.LEVEL2, "장바구니"));
		missions.add(new Mission(Course.FRONTEND, Level.LEVEL2, "결제"));
		missions.add(new Mission(Course.FRONTEND, Level.LEVEL2, "지하철노선도"));

		missions.add(new Mission(Course.FRONTEND, Level.LEVEL4, "성능개선"));
		missions.add(new Mission(Course.FRONTEND, Level.LEVEL4, "배포"));



	}


}
