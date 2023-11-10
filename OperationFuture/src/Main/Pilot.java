package Main;

import Map.*;
import Scenes.HQ_;
import Scenes.Location;
import UI.UI;

public class Pilot implements Runnable { //context 
	
	private String name;
	private UI ui;
	private Thread pilot;
	
	//private Location localLocation;
	
	private State currentLocation;

	
	public Pilot(UI ui) {
		this.ui = ui;
		//this.currentLocation = Map.map.get(game_locations.HQ.getLocationIndex());
		
		this.currentLocation = new HQ_();
		
		pilot = new Thread (this);
		pilot.start();
	}


	public synchronized String getName() {
		return name;
	}


	public synchronized void setName(String name) {
		this.name = name;
	}
	
//	public synchronized void setLocation(Location currentLocation) {
//		this.currentLocation = currentLocation;
//	}
//	
//	public synchronized Location getCurrentLocation() {
//		return currentLocation;
//	}
	
	

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	public synchronized void nextLocation() {
		currentLocation.next(this); 
		
	}
	
	public synchronized void printStatus() {
		currentLocation.printStatus(); 
		
	}
	
	public synchronized void printGrid() {
		currentLocation.printGrid(); 
		
	}
	
	
	
	public  synchronized void setState(State newLocation) {
		this.currentLocation = newLocation;
}
	
	

}
