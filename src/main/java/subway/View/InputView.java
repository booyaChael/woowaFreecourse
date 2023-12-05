package subway.View;

import java.util.Scanner;

public class InputView {
	static final Scanner scanner = new Scanner(System.in);
	static public String getFunctionSelect(){
		System.out.println("## 원하는 기능을 선택하세요.");
		return scanner.next();
	}

	// 역 관리
	static public String getStationToRegister(){
		System.out.println("## 등록할 역 이름을 입력하세요.");
		return scanner.next();
	}

	static public String getStationToDelete(){
		System.out.println("## 삭제할 역 이름을 입력하세요.");
		return scanner.next();
	}

	//노선 관리
	static public String getLineToRegister(){
		System.out.println("## 등록할 노선 이름을 입력하세요.");
		return scanner.next();
	}

	static public String getStartStationOfLine(){
		System.out.println("## 등록할 노선의 상행 종점역 이름을 입력하세요.");
		return scanner.next();
	}

	static public String getEndStationOfLine(){
		System.out.println("## 등록할 노선의 하행 종점역 이름을 입력하세요.");
		return scanner.next();
	}

	static public String getLineToDelete(){
		System.out.println("## 삭제할 노선 이름을 입력하세요.");
		return scanner.next();
	}

	// 구간 관리
	static public String getLineToRegisterSection(){
		System.out.println("## 노선을 입력하세요.");
		return scanner.next();
	}

	static public String getStationToRegisterSection(){
		System.out.println("## 역이름을 입력하세요.");
		return scanner.next();
	}

	static public int getOrderToRegisterSection(){
		System.out.println("## 순서를 입력하세요.");
		return scanner.nextInt();
	}


}
