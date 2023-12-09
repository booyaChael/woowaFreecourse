package subway.Service;

import subway.View.InputView;
import subway.View.OutputView;
import subway.domain.SectionRepository;

public class SectionManager {
	public void run(){
		while(true){
			try{
				OutputView.printSectionFunction();
				String function = InputView.getFunctionSelect();
				if(function.equals("1")){
					registerSection();
				}
				if(function.equals("2")){
					deleteSection();
				}
				if(function.equals("B")){
					return;
				}
			}catch(IllegalArgumentException e){
				System.out.println(e.getMessage());
			}
		}
	}

	private void registerSection(){
		while(true){
			try{
				String lineName = InputView.getLineToRegisterSection();
				validateLineNameToRegister(lineName);

				String stationName = InputView.getStationToRegisterSection();
				validateStationToRegister(stationName);

				int order = InputView.getOrderToRegisterSection();
				validateOrder(order);

				SectionRepository.addStationToSection(lineName, stationName, order);
				break;
			}catch(IllegalArgumentException e){
				System.out.println(e.getMessage());
			}
		}
	}

	private void deleteSection(){
		String lineName = InputView.getLineToDeleteSection();
		validateLineNameToDelete(lineName);
		SectionRepository.deleteSection(lineName);
	}

	private void validateLineNameToRegister(String lineName){
		Validator.lineShouldExist(lineName);
	}

	private void validateLineNameToDelete(String lineName){
		Validator.lineShouldExist(lineName);
	}

	private void validateStationToRegister(String stationName){
		Validator.stationShouldExist(stationName);
	}

	private void validateOrder(int order){
		Validator.orderShouldBeSmallerThanSectionSize(order);
	}
}
