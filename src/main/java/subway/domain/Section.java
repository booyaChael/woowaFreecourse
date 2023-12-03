//Section.java
package subway.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Section {
	private Line line;
	private List<Station> stations;

	public Section(Line line, Station fromStation, Station toStation, Station... otherStations){
		this.line = line;
		List<Station> stationList = new ArrayList<>();
		stationList.add(fromStation);
		stationList.addAll(Arrays.asList(otherStations));
		stationList.add(toStation);
		this.stations = new ArrayList<>(stationList);
	}

	public void addStationByIndex(int index, Station station){
		if (index >= 0 && index <= stations.size()) {
			stations.add(index, station);
		} else {
			throw new IllegalArgumentException("[ERROR] 존재하지 않는 순서 번호입니다.");
		}
	}

}
