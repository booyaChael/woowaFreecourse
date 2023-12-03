//StationRepository.java
package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class StationRepository {
    private static final List<Station> stations = new ArrayList<>();

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static void addStation(Station station) {
        stations.add(station);
    }

    public static boolean deleteStation(String name) {
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }

    public static Station getStationByName(String name) {
        for(Station station : stations){
            if(name.equals(station.getName())){
                return station;
            }
        }
        throw new IllegalArgumentException("[ERROR] 해당되는 역 이름이 존재하지 않습니다.");
    }

    static {
        addStation(new Station("교대역"));
        addStation(new Station("강남역"));
        addStation(new Station("역삼역"));

        addStation(new Station("남부터미널역"));
        addStation(new Station("양재역"));
        addStation(new Station("매봉역"));

        addStation(new Station("양재시민의숲역"));
    }
}
