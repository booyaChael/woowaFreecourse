//PairRepository.java
package pairmatching.Domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PairsRepository {
	private static final Map<Mission, List<Pair>> pairsMap = new HashMap<>();

	public static void addPairs(Mission mission, List<Pair> pairs){
		pairsMap.put(mission, pairs);
	}

	public static List<Pair> getPairsByMission(Mission mission){
		return pairsMap.get(mission);
	}

	public static boolean haveSamePairInSameLevel(Mission mission, List<Pair> pairs) {
		List<Mission> missionsInSameLevel = MissionRepository.findMissionsWithSameCourseAndLevel(mission);

		for (Mission missionInSameLevel : missionsInSameLevel) {
			List<Pair> pairsInSameLevel = getPairsByMission(missionInSameLevel);

			if (pairsInSameLevel != null && containsSamePair(pairsInSameLevel, pairs)) {
				return true;
			}
		}

		return false;
	}

	private static boolean containsSamePair(List<Pair> pairsInSameLevel, List<Pair> pairs) {
		return pairsInSameLevel.stream().anyMatch(pairs::contains);
	}

	public static void deleteAll() {
		pairsMap.clear();
	}


}
