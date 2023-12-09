package pairmatching;

public class Application {
    public static void main(String[] args) {
        // TODO 구현 진행
        PairMatchManager pairMatchManager = new PairMatchManager();
        PairReadManager pairReadManager = new PairReadManager();
        PairResetManager pairResetManager = new PairResetManager();

        Program program = new Program(pairMatchManager, pairReadManager, pairResetManager);
        program.run();
    }
}
