package pairmatching;

import pairmatching.View.InputView;

public class Program {
	PairMatchManager pairMatchManager;
	PairReadManager pairReadManager;
	PairResetManager pairResetManager;

	public Program(PairMatchManager pairMatchManager, PairReadManager pairReadManager, PairResetManager pairResetManager) {
		this.pairMatchManager = pairMatchManager;
		this.pairReadManager = pairReadManager;
		this.pairResetManager = pairResetManager;
	}

	public void run(){
		String function = InputView.getFunction();
		if(function.equals("1")){
			pairMatchManager.run();
		}
		if(function.equals("2")){
			pairReadManager.run();
		}
		if(function.equals("3")){
			pairResetManager.run();
		}
		if(function.equals("Q")){
			return;
		}
	}
}
