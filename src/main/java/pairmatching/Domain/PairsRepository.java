package pairmatching.Domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PairsRepository {
	private static final Map<Mission, List<Pair>> pairsMap = new HashMap<>();

	public static void addPairs(Mission mission, List<Pair> pairs){
		pairsMap.put(mission, pairs);
	}


}
