package Scenes;

import Main.Pilot;
import Map.State;

public class ProminentCity extends Location implements State {

	@Override
	public void next(Pilot currentLocation) {
		currentLocation.setState(new HiddenLocation());
		
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
