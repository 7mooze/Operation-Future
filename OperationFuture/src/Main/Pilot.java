package Main;

import java.util.ArrayList;

import Grids.Grid;
import Map.*;
import Objects.Object;
import Sahara_grid.SaharaGrid;
import Scenes.HQ_;
import Scenes.Location;
import UI.UI;

public class Pilot implements Runnable { //context 
	
	private String name;
	private UI ui;
	private Thread pilot;
	
	//private Location localLocation;
	private Grid currentGrid;
	
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
	
	public synchronized void setGrid(Grid currentGrid) {
		this.currentGrid = currentGrid;
	}
	
	public synchronized Grid getCurrentGrid() {
		return currentGrid;
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
	
	
	
	public void move(ArrayList<String> input) {
		
		String direction = input.get(1);
		int exitIndex=0;
		
		switch(direction) {
		
		case "up":
			exitIndex = currentGrid.Up;
			break;
			
		case "down":
			exitIndex = currentGrid.Down;
			break;
			
		case "right":
			exitIndex = currentGrid.Right;
			break;
			
		case "left":
			exitIndex = currentGrid.Left;
			break;
			
		default:
			exitIndex = -2;
			
		}
		
		if (exitIndex == -2) {
			ui.println("\nInvalid Location!, please try again\n");
		}else if(exitIndex == -1) {
			ui.println("\nYou bumped into a wall! try something else\n");
			
		}else {
			// Update the current location with the new location index
			currentGrid = SaharaGrid.grid.get(exitIndex);
	        
	        ui.println("\n" +currentGrid.name);
		}
		
	}
	
	public void use(ArrayList<String> input) {
	    if (input.size() < 2 || !input.get(0).equals("use")) {
	    	ui.println("Invalid use command. Use 'use <object>' format.");
	        return;
	    }

	    String objectName = String.join(" ", input.subList(1, input.size())).toLowerCase();

	    boolean objectUsed = false;

	    // Iterate through the objects in the current location
	    for (String objName : currentGrid.listOfObjects) {
	    	if (objName.equalsIgnoreCase(objectName)) {
	    	int index = currentGrid.listOfObjects.indexOf(objName);
	    		
	    		((Object) currentGrid.objects.get(index)).use();
	           
	            objectUsed = true;
	            break;
	        }
	    }

	    if (!objectUsed) {
	    	ui.println("You can't use that object here.");
	    }
	}
	
	public void show(ArrayList<String> input) { 
	    if (input.size() == 1) {
	        //
	    } 
	}

	@Override
	public void run() {
		
		// TODO Auto-generated method stub
		
	}


	
	

}
