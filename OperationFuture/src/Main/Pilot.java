package Main;

import Map.*;
import Scenes.Location;
import UI.UI;

public class Pilot implements Runnable {
	
	private String name;
	private UI ui;
	private Thread pilot;
	private Location currentLocation;

	
	public Pilot(UI ui) {
		this.ui = ui;
		this.currentLocation = Map.map.get(game_locations.HQ.getLocationIndex());
		
		pilot = new Thread (this);
		pilot.start();
	}


	public synchronized String getName() {
		return name;
	}


	public synchronized void setName(String name) {
		this.name = name;
	}
	
	public synchronized void setLocation(Location currentLocation) {
		this.currentLocation = currentLocation;
	}
	
	public synchronized Location getCurrentLocation() {
		return currentLocation;
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
	

}
