//SectionRepository.java
package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SectionRepository {
	private static final List<Section> sections = new ArrayList<>();

	public static List<Section> sections() {
		return Collections.unmodifiableList(sections);
	}

	public static void addSection(Section section){
		sections.add(section);
	}

	public static void addStationToSection(String lineName, String stationName, int index){
		Section section = getSectionByLineName(lineName);
		Station station = StationRepository.getStationByName(stationName);
		section.addStationByIndex(index, station);
	}

	public static Section getSectionByLineName(String lineName){
		Line line = LineRepository.getLineByName(lineName);
		for(Section section : sections){
			if(line.equals(section.getLine())){
				return section;
			}
		}
		return null;
	}

	static {
		Line line2 = LineRepository.getLineByName("2호선");
		Line line3 = LineRepository.getLineByName("3호선");
		Line lineSinBundang = LineRepository.getLineByName("신분당선");

		addSection(new Section(line2));
		addSection(new Section(line3));
		addSection(new Section(lineSinBundang));
	}
}
