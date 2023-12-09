package pairmatching;

import pairmatching.Domain.PairsRepository;
import pairmatching.View.OutputView;

public class PairResetManager {
	public void run(){
		PairsRepository.deleteAll();
		OutputView.printResetSuccessed();
	}
}
