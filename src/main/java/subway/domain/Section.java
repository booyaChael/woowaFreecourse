//Section.java
package subway.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Section {
	private Line line;
	private List<Station> stations;

	public Section(Line line){
		this.line = line;
		this.stations = new ArrayList<>(List.of(line.getStartStation(), line.getEndStation()));
	}

	public Line getLine(){
		return line;
	}

	public void addStationByIndex(int index, Station station){
		if (index >= 0 && index <= stations.size()) {
			stations.add(index, station);
		} else {
			throw new IllegalArgumentException("[ERROR] 존재하지 않는 순서 번호입니다.");
		}
	}

}
