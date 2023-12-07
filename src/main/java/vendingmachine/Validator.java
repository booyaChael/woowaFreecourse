package vendingmachine;

public class Validator {
	static public void checkIsNumber(String input) {
		try {
			Integer.parseInt(input);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("[ERROR] 입력값은 숫자여야 합니다.");
		}
	}
	static public void checkIsDividedBy10(int number){
		if (number % 10 != 0) {
			throw new IllegalArgumentException("[ERROR] 상품 가격은 100원부터 시작하며, 10원으로 나누어떨어져야 합니다.");
		}
	}

	static public void checkOver100(int number){
		if (number < 100) {
			throw new IllegalArgumentException("[ERROR] 상품 가격은 100원부터 시작하며, 10원으로 나누어떨어져야 합니다.");
		}
	}

	static public void checkLengthNotUnder2(String input){
		if(input.length() < 2){
			throw new IllegalArgumentException("[ERROR] 상품명은 2글자 이상이어야 합니다.");
		}
	}

	static public void checkOver1(int number){
		if(number < 1){
			throw new IllegalArgumentException("[ERROR] 상품 수량은 1 이상으로 입력해야 합니다.");
		}
	}
}
