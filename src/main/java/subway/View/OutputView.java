package subway.View;

import java.util.List;

import subway.domain.Line;
import subway.domain.Station;

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
		System.out.println("\n[INFO] 지하철 역이 등록되었습니다.\n");
	}

	static public void printAllStations(List<Station> stations){
		System.out.println("");
		for(Station station : stations){
			System.out.printf("[INFO] %s\n", station.getName());
		}
	}

	static public void printLineFunction(){
		System.out.println("## 노선 관리 화면\n"
			+ "1. 노선 등록\n"
			+ "2. 노선 삭제\n"
			+ "3. 노선 조회\n"
			+ "B. 돌아가기\n");
	}

	static public void printAllLines(List<Line> lines){
		System.out.println("");
		for(Line line : lines){
			System.out.printf("[INFO] %s\n", line.getName());
		}
	}

	static public void printSectionFunction(){
		System.out.println("## 구간 관리 화면\n"
			+ "1. 구간 등록\n"
			+ "2. 구간 삭제\n"
			+ "B. 돌아가기\n");
	}
}
