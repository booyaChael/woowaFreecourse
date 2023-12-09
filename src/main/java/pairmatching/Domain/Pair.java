//Pair.java
package pairmatching.Domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pair {
	List<Crew> pair;

	public Pair(Crew... pair) {
		this.pair = new ArrayList<>(Arrays.asList(pair));
	}

	public String makePairToString() {
		StringBuilder result = new StringBuilder();

		for (int i = 0; i < pair.size(); i++) {
			result.append(pair.get(i).getName());

			if (i < pair.size() - 1) {
				result.append(" : ");
			}
		}

		return result.toString();
	}
}
