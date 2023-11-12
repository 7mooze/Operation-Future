package Scenes;

import Main.Pilot;
import Map.State;

public class HiddenLocation extends Location implements State {

	@Override
	public void next(Pilot currentLocation) {
		currentLocation.setState(new HQ_());
		
	}

	@Override
	public void printStatus() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void printGrid() {
		// TODO Auto-generated method stub
		
	}

}
