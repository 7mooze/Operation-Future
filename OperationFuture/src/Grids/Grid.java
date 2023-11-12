package Grids;

import java.util.ArrayList;

import Characters.Alien;
import Objects.Object;

public abstract class Grid {
	
	public String name;
	public boolean won = false;
	
	
	public ArrayList<Alien> aliens;
	public ArrayList<Object> objects;
	public ArrayList<String> listOfObjects;
	
	public int Up, Down, Left, Right;
	
	public void setExits(grid_boxes UpExit, grid_boxes DownExit, grid_boxes RightExit, grid_boxes LeftExit) {
		
		Up = UpExit.getGridIndex();
		Down = DownExit.getGridIndex();
		Right = RightExit.getGridIndex();
		Left = LeftExit.getGridIndex();
		
	}
}
