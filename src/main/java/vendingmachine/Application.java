package vendingmachine;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        CoinsMaker coinsMaker = new CoinsMaker();
        ProductsMaker productsMaker = new ProductsMaker();

        Program program = new Program(coinsMaker, productsMaker);
        program.run();
    }
}
