package vendingmachine;

public enum Coin {
    // 필드(인스턴스 변수)인 amount의 접근 제어자 private을 변경할 수 없다.
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);

    private final int amount;

    Coin(final int amount) {
        this.amount = amount;
    }

    public int getAmount(){
        return this.amount;
    }

    public static Coin findByAmount(int amount) {
        for (Coin coin : values()) {
            if (coin.getAmount() == amount) {
                return coin;
            }
        }
        return null;
    }
}
