package subway.View;

import java.util.Scanner;

public class InputView {
	static final Scanner scanner = new Scanner(System.in);
	static public String getFunctionSelectInput(){
		System.out.println("## 원하는 기능을 선택하세요.");
		return scanner.next();
	}

	static public String getStationToRegisterInput(){
		System.out.println("## 등록할 역 이름을 입력하세요.");
		return scanner.next();
	}

	static public String getStationToDeleteInput(){
		System.out.println("## 삭제할 역 이름을 입력하세요.");
		return scanner.next();
	}

	static public String getLineToRegisterInput(){
		System.out.println("## 등록할 노선 이름을 입력하세요.");
		return scanner.next();
	}

	static public String getStartStationOfLineInput(){
		System.out.println("## 등록할 노선의 상행 종점역 이름을 입력하세요.");
		return scanner.next();
	}

	static public String getEndStationOfLineInput(){
		System.out.println("## 등록할 노선의 하행 종점역 이름을 입력하세요.");
		return scanner.next();
	}

	static public String getLineToDeleteInput(){
		System.out.println("## 삭제할 노선 이름을 입력하세요.");
		return scanner.next();
	}


}
