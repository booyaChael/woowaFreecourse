package pairmatching.Domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MissionRepository {
	private static final List<Mission> missions = new ArrayList<>();

	public static void addMission(Course course, Level level, String missionName){
		missions.add(new Mission(course, level, missionName));
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
