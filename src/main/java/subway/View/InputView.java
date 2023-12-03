package subway.View;

import java.util.Scanner;

public class InputView {
	static final Scanner scanner = new Scanner(System.in);
	static public int getFunctionSelectInput(){
		System.out.println("## 원하는 기능을 선택하세요.");
		return scanner.nextInt();
	}
}
