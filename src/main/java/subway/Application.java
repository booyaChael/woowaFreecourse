package subway;


import subway.Service.LineManager;
import subway.Service.SectionManager;
import subway.Service.StationManager;

public class Application {
    public static void main(String[] args) {
        LineManager lineManager = new LineManager();
        StationManager stationManager = new StationManager();
        SectionManager sectionManager = new SectionManager();

        Program program = new Program(stationManager,lineManager, sectionManager);
        program.run();
    }
}
