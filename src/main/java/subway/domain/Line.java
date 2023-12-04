package subway.domain;

public class Line {
    private String name;
    private Station startStation;
    private Station endStation;

    public Line(String name, Station startStation, Station endStation) {
        this.name = name;
        this.startStation = startStation;
        this.endStation = endStation;
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현
}
