package pairmatching;

import pairmatching.Domain.PairsRepository;

public class PairResetManager {
	public void run(){
		PairsRepository.deleteAll();
	}
}
