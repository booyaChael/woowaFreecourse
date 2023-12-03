//LineRepository.java
package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LineRepository {
    private static final List<Line> lines = new ArrayList<>();

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(Line line) {
        lines.add(line);
    }

    public static boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

    public static Line getLineByName(String name){
        for(Line line : lines){
            if(name.equals(line.getName())){
                return line;
            }
        }
        throw new IllegalArgumentException("[ERROR] 해당되는 노선이 존재하지 않습니다.");
    }

    static {
        addLine(new Line("2호선"));
        addLine(new Line("3호선"));
        addLine(new Line("신분당선"));
    }
}
