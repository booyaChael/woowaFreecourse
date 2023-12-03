package subway.View;

public class OutputView {
	static public void printMainFunction(){
		System.out.println("## 메인 화면\n"
			+ "1. 역 관리\n"
			+ "2. 노선 관리\n"
			+ "3. 구간 관리\n"
			+ "4. 지하철 노선도 출력\n"
			+ "Q. 종료\n");
	}

	static public void printStationFunction(){
		System.out.println("## 역 관리 화면\n"
			+ "1. 역 등록\n"
			+ "2. 역 삭제\n"
			+ "3. 역 조회\n"
			+ "B. 돌아가기\n");
	}

	static public void printStationRegisteredSuccess(){
		System.out.println("[INFO] 지하철 역이 등록되었습니다.");
	}

	static public void printLineFunction(){
		System.out.println("## 노선 관리 화면\n"
			+ "1. 노선 등록\n"
			+ "2. 노선 삭제\n"
			+ "3. 노선 조회\n"
			+ "B. 돌아가기\n");
	}

	static public void printSectionFunction(){
		System.out.println("## 구간 관리 화면\n"
			+ "1. 구간 등록\n"
			+ "2. 구간 삭제\n"
			+ "B. 돌아가기\n");
	}
}
