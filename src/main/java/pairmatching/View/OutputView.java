package pairmatching.View;

import java.util.List;

import pairmatching.Domain.Pair;

public class OutputView {
	static public void printPairs(List<Pair> pairs){
		System.out.println("페어 매칭 결과입니다.");
		for(Pair pair : pairs){
			System.out.println(pair.makePairToString());
		}
	}
}
