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

	static {
		Line line2 = LineRepository.getLineByName("2호선");
		Line line3 = LineRepository.getLineByName("3호선");
		Line lineSinBundang = LineRepository.getLineByName("신분당선");

		Station station_강남 = StationRepository.getStationByName("강남역");
		Station station_교대 = StationRepository.getStationByName("교대역");
		Station station_역삼 = StationRepository.getStationByName("역삼역");
		Station station_매봉 = StationRepository.getStationByName("매봉역");
		Station station_남부터미널 = StationRepository.getStationByName("남부터미널역");
		Station station_양재 = StationRepository.getStationByName("양재역");
		Station station_양재시민의숲 = StationRepository.getStationByName("양재시민의숲역");

		addSection(new Section(line2, station_교대, station_역삼, station_강남));
		addSection(new Section(line3, station_교대, station_매봉, station_남부터미널, station_양재));
		addSection(new Section(lineSinBundang, station_강남, station_양재, station_양재시민의숲));
	}



}
