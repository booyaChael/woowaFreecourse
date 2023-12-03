package subway.domain;

import java.util.List;

public class SubwayMap {
	List<Station> stations;
	List<Line> lines;
	List<Section> sections;

	public SubwayMap(List<Station> stations, List<Line> lines, List<Section> sections){
		this.stations = stations;
		this.lines = lines;
		this.sections = sections;
	}
}
